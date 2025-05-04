package org.kadampabookings.kbsx.catering.backoffice.operations.entities.allocationrule;

import dev.webfx.stack.i18n.HasI18nKey;
import dev.webfx.stack.i18n.I18nKeys;
import javafx.scene.layout.Pane;
import one.modality.base.client.i18n.BaseI18nKeys;
import one.modality.base.shared.entities.Event;
import dev.webfx.stack.ui.operation.HasOperationCode;
import dev.webfx.stack.ui.operation.HasOperationExecutor;
import dev.webfx.platform.async.AsyncFunction;

public final class AddNewAllocationRuleRequest implements HasOperationCode, HasI18nKey,
        HasOperationExecutor<AddNewAllocationRuleRequest, Void> {

    private final static String OPERATION_CODE = "AddNewAllocationRule";

    private final Event event;
    private final Pane parentContainer;

    public AddNewAllocationRuleRequest(Event event, Pane parentContainer) {
        this.event = event;
        this.parentContainer = parentContainer;
    }

    Event getEvent() {
        return event;
    }

    Pane getParentContainer() {
        return parentContainer;
    }

    @Override
    public Object getOperationCode() {
        return OPERATION_CODE;
    }

    @Override
    public Object getI18nKey() {
        return I18nKeys.appendEllipsis(BaseI18nKeys.Add);
    }

    @Override
    public AsyncFunction<AddNewAllocationRuleRequest, Void> getOperationExecutor() {
        return AddNewAllocationRuleExecutor::executeRequest;
    }
}
