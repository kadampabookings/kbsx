// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.ecommerce.frontoffice.activities.summary {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.ecommerce.client.bookingoptionspanel;
    requires kbsx.ecommerce.client.bookingprocess;
    requires kbsx.ecommerce.client.businesslogic;
    requires kbsx.ecommerce.frontoffice.activities.cart.routing;
    requires kbsx.event.client.bookingcalendar;
    requires kbsx.event.client.sectionpanel;
    requires modality.base.client.util;
    requires modality.base.shared.entities;
    requires modality.crm.client.personaldetails;
    requires webfx.extras.i18n;
    requires webfx.extras.validation;
    requires webfx.kit.util;
    requires webfx.platform.console;
    requires webfx.platform.util;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity.controls;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.ecommerce.frontoffice.activities.summary;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.ecommerce.frontoffice.activities.summary.SummaryRouting.SummaryUiRoute;

}