package org.kadampabookings.kbsx.ecommerce.client.businessdata.preselection;

import one.modality.base.client.entities.util.Labels;
import org.kadampabookings.kbsx.hotel.shared.businessdata.time.DateTimeRange;
import org.kadampabookings.kbsx.hotel.shared.businessdata.time.DayTimeRange;
import org.kadampabookings.kbsx.base.client.aggregates.event.EventAggregate;
import one.modality.base.shared.entities.Label;
import org.kadampabookings.kbsx.base.shared.entities.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class OptionsPreselectionBuilder {

    private final EventAggregate eventAggregate;
    private final DateTimeRange dateTimeRange;
    private final List<OptionPreselection> optionPreselections = new ArrayList<>();
    private Label label;
    private String i18nKey; // alternative i18n key if label is null
    private boolean hasAccommodation;
    private boolean nightIsCovered;

    public OptionsPreselectionBuilder(EventAggregate eventAggregate, DateTimeRange dateTimeRange) {
        this.eventAggregate = eventAggregate;
        this.dateTimeRange = dateTimeRange;
    }

    public OptionsPreselectionBuilder addDefaultOptions(Iterable<Option> options) {
        for (Option option : options)
            addOption(option);
        return this;
    }

    public OptionsPreselectionBuilder addAccommodationOption(Option option) {
        if (option != null) {
            hasAccommodation = true;
            if (addOption(option))
                nightIsCovered = true;
            label = Labels.bestLabelOrName(option);
        } else
            i18nKey = "NoAccommodation";
        return this;
    }

    private boolean addOption(Option option) {
        DateTimeRange optionDateTimeRange = option.getParsedDateTimeRangeOrParent();
        DateTimeRange finalDateTimeRange = dateTimeRange;
        if (optionDateTimeRange != null)
            finalDateTimeRange = finalDateTimeRange.intersect(optionDateTimeRange);
        DayTimeRange dayTimeRange = option.getParsedTimeRangeOrParent();
        if (dayTimeRange != null)
            finalDateTimeRange = finalDateTimeRange.intersect(dayTimeRange);
        if (finalDateTimeRange.isEmpty())
            return false;
        optionPreselections.add(new OptionPreselection(option, finalDateTimeRange, dayTimeRange));
        return true;
    }

    public OptionsPreselection build() {
        return hasAccommodation && !nightIsCovered ? null : new OptionsPreselection(eventAggregate, label, i18nKey, optionPreselections);
    }

}
