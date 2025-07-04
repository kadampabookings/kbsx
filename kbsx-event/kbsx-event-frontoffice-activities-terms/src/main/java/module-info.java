// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.frontoffice.activities.terms {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.client.icons;
    requires kbsx.ecommerce.client.bookingprocess;
    requires kbsx.event.client.sectionpanel;
    requires modality.base.client.util;
    requires webfx.extras.i18n;
    requires webfx.extras.util.layout;
    requires webfx.extras.visual;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.frontoffice.activities.terms;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.frontoffice.activities.terms.TermsRouting.TermsUiRoute;

}