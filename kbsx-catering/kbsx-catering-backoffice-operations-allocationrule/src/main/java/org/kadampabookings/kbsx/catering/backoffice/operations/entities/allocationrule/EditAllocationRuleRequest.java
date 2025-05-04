package org.kadampabookings.kbsx.catering.backoffice.operations.entities.allocationrule;

import dev.webfx.platform.async.AsyncFunction;
import dev.webfx.stack.i18n.HasI18nKey;
import dev.webfx.stack.i18n.I18nKeys;
import dev.webfx.stack.orm.entity.Entity;
import dev.webfx.stack.ui.operation.HasOperationCode;
import dev.webfx.stack.ui.operation.HasOperationExecutor;
import javafx.scene.layout.Pane;
import one.modality.base.client.i18n.BaseI18nKeys;

public final class EditAllocationRuleRequest implements HasOperationCode, HasI18nKey,
        HasOperationExecutor<EditAllocationRuleRequest, Void> {

    private final static String OPERATION_CODE = "EditAllocationRule";

    private final Entity allocationRule;
    private final Pane parentContainer;

    public EditAllocationRuleRequest(Entity allocationRule, Pane parentContainer) {
        this.allocationRule = allocationRule;
        this.parentContainer = parentContainer;
    }

    Entity getAllocationRule() {
        return allocationRule;
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
        return I18nKeys.appendEllipsis(BaseI18nKeys.Edit);
    }

    @Override
    public AsyncFunction<EditAllocationRuleRequest, Void> getOperationExecutor() {
        return EditAllocationRuleExecutor::executeRequest;
    }
}
