package org.kadampabookings.kbsx.event.backoffice.activities.cloneevent;

import dev.webfx.kit.util.properties.FXProperties;
import dev.webfx.stack.db.submit.SubmitArgument;
import dev.webfx.stack.db.submit.SubmitService;
import one.modality.base.shared.entities.Event;
import one.modality.ecommerce.backoffice.activities.bookings.BookingsRouting;
import org.kadampabookings.kbsx.event.client.activity.eventdependent.EventDependentPresentationLogicActivity;

import java.time.LocalDate;

/**
 * @author Bruno Salmon
 */
public final class CloneEventPresentationLogicActivity extends EventDependentPresentationLogicActivity<CloneEventPresentationModel> {

    public CloneEventPresentationLogicActivity() {
        super(CloneEventPresentationModel::new);
    }

    @Override
    protected void startLogic(CloneEventPresentationModel pm) {
        // Load and display fees groups now but also on event change
        FXProperties.runNowAndOnPropertyChange(() -> {
            pm.setName(null);
            pm.setDate(null);
            onEventOptions().onSuccess(options -> {
                Event event = getEvent();
                pm.setName(event.getName());
                pm.setDate(event.getStartDate());
            });
        }, pm.eventIdProperty());

        pm.setOnSubmit(event -> {
            LocalDate startDate = pm.getDate();
            SubmitService.executeSubmit(SubmitArgument.builder()
                    .setStatement("select copy_event(?,?,?)")
                    .setParameters(getEventId(), pm.getName(), startDate)
                    .setReturnGeneratedKeys(true)
                    .setDataSourceId(getDataSourceId())
                    .build())
                .inUiThread()
                .onSuccess(result ->
                        new BookingsRouting.RouteToBookingsRequest(result.getGeneratedKeys()[0], getHistory()).execute()
                    );
        });
    }
}
