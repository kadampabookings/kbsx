// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.backoffice.activities.options {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.backoffice.multilangeditor;
    requires kbsx.base.client.icons;
    requires kbsx.base.shared.entities;
    requires kbsx.ecommerce.client.businesslogic;
    requires kbsx.event.client.bookingcalendar;
    requires kbsx.event.client.calendar;
    requires kbsx.event.frontoffice.activities.options;
    requires kbsx.hotel.shared.time;
    requires modality.base.shared.entities;
    requires webfx.extras.util.dialog;
    requires webfx.extras.util.layout;
    requires webfx.extras.visual.grid;
    requires webfx.kit.util;
    requires webfx.stack.db.submit;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.entity;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.backoffice.activities.options;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.backoffice.activities.options.EditableOptionsUiRoute;

}