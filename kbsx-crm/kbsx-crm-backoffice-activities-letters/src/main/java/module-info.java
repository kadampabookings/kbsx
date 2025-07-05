// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.crm.backoffice.activities.letters {

    // Direct dependencies modules
    requires javafx.graphics;
    requires kbsx.crm.backoffice.activities.letter;
    requires modality.base.client.activity;
    requires modality.base.client.util;
    requires modality.event.client.activity.eventdependent;
    requires webfx.extras.operation;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.router;
    requires webfx.stack.routing.router.client;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.crm.backoffice.activities.letters;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.crm.backoffice.activities.letters.LettersRouting.LettersUiRoute;
    provides dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter with org.kadampabookings.kbsx.crm.backoffice.activities.letters.LettersRouting.RouteToLettersRequestEmitter;

}