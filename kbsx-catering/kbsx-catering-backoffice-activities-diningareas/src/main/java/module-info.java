// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.catering.backoffice.activities.diningareas {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.catering.backoffice.operations.allocationrule;
    requires kbsx.ecommerce.backoffice.activities.statistics;
    requires kbsx.event.client.activity.eventdependent;
    requires modality.base.backoffice.masterslave;
    requires modality.base.backoffice.operations.generic;
    requires modality.base.client.util;
    requires modality.base.shared.entities;
    requires modality.event.client.activity.eventdependent;
    requires webfx.extras.operation;
    requires webfx.extras.operation.action;
    requires webfx.extras.visual;
    requires webfx.extras.visual.grid;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.entity;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.router;
    requires webfx.stack.routing.router.client;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.catering.backoffice.activities.diningareas;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.catering.backoffice.activities.diningareas.DiningAreasRouting.DiningAreasUiRoute;
    provides dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter with org.kadampabookings.kbsx.catering.backoffice.activities.diningareas.DiningAreasRouting.RouteToDiningAreasRequestEmitter;

}