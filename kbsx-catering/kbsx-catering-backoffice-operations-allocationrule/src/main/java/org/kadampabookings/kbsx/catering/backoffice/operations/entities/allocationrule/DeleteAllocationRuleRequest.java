package org.kadampabookings.kbsx.catering.backoffice.operations.entities.allocationrule;

import dev.webfx.extras.i18n.HasI18nKey;
import dev.webfx.extras.i18n.I18nKeys;
import javafx.scene.layout.Pane;
import dev.webfx.extras.operation.HasOperationCode;
import dev.webfx.extras.operation.HasOperationExecutor;
import dev.webfx.stack.orm.entity.Entity;
import dev.webfx.platform.async.AsyncFunction;
import one.modality.base.client.i18n.BaseI18nKeys;

public final class DeleteAllocationRuleRequest implements HasOperationCode, HasI18nKey,
        HasOperationExecutor<DeleteAllocationRuleRequest, Void> {

    private final static String OPERATION_CODE = "DeleteAllocationRule";

    private final Entity documentLine;
    private final Pane parentContainer;

    public DeleteAllocationRuleRequest(Entity documentLine, Pane parentContainer) {
        this.documentLine = documentLine;
        this.parentContainer = parentContainer;
    }

    Entity getDocumentLine() {
        return documentLine;
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
        return I18nKeys.appendEllipsis(BaseI18nKeys.Delete);
    }

    @Override
    public AsyncFunction<DeleteAllocationRuleRequest, Void> getOperationExecutor() {
        return DeleteAllocationRuleExecutor::executeRequest;
    }
}
