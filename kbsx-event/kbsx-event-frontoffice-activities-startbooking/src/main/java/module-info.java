// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.frontoffice.activities.startbooking {

    // Direct dependencies modules
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.client.icons;
    requires kbsx.base.shared.entities;
    requires kbsx.ecommerce.client.bookingprocess;
    requires kbsx.event.frontoffice.activities.fees;
    requires kbsx.event.frontoffice.activities.options;
    requires kbsx.event.frontoffice.activities.program;
    requires kbsx.event.frontoffice.activities.terms;
    requires modality.base.client.entities;
    requires modality.base.client.util;
    requires webfx.extras.action;
    requires webfx.extras.imagestore;
    requires webfx.extras.util.animation;
    requires webfx.extras.util.control;
    requires webfx.extras.util.layout;
    requires webfx.kit.util;
    requires webfx.platform.console;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.frontoffice.activities.startbooking;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.frontoffice.activities.startbooking.StartBookingRouting.StartBookingUiRoute;

}