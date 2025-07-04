// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.frontoffice.activities.options {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.client.icons;
    requires kbsx.base.shared.entities;
    requires kbsx.ecommerce.client.bookingprocess;
    requires kbsx.ecommerce.client.businesslogic;
    requires kbsx.ecommerce.frontoffice.activities.person;
    requires kbsx.event.client.bookingcalendar;
    requires kbsx.event.client.sectionpanel;
    requires kbsx.hotel.shared.time;
    requires modality.base.client.entities;
    requires modality.base.client.util;
    requires modality.base.shared.entities;
    requires webfx.extras.i18n;
    requires webfx.extras.imagestore;
    requires webfx.extras.panes;
    requires webfx.extras.util.layout;
    requires webfx.extras.validation;
    requires webfx.kit.util;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.util;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity;
    requires webfx.stack.orm.entity.controls;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.frontoffice.activities.options;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.frontoffice.activities.options.OptionsRouting.OptionsUiRoute;

}