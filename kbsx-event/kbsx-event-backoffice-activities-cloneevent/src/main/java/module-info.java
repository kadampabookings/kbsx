// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.backoffice.activities.cloneevent {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.shared.entities;
    requires kbsx.event.backoffice.activities.cloneevent.routing;
    requires kbsx.event.client.activity.eventdependent;
    requires modality.base.client.activity;
    requires modality.base.shared.entities;
    requires modality.booking.backoffice.activity.bookings.plugin;
    requires modality.event.client.activity.eventdependent;
    requires webfx.extras.controlfactory;
    requires webfx.extras.time.format;
    requires webfx.extras.util.dialog;
    requires webfx.kit.util;
    requires webfx.stack.db.submit;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.backoffice.activities.cloneevent;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.backoffice.activities.cloneevent.CloneEventUiRoute;

}