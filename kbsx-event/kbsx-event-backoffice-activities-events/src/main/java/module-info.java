// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.backoffice.activities.events {

    // Direct dependencies modules
    requires javafx.graphics;
    requires modality.base.client.activity;
    requires modality.base.client.util;
    requires modality.booking.backoffice.activity.bookings.plugin;
    requires modality.crm.backoffice.organization.fx;
    requires modality.event.backoffice.events.pm;
    requires webfx.extras.operation;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.router;
    requires webfx.stack.routing.router.client;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.backoffice.activities.events;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.backoffice.activities.events.EventsRouting.EventsUiRoute;
    provides dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter with org.kadampabookings.kbsx.event.backoffice.activities.events.EventsRouting.RouteToEventsRequestEmitter;

}