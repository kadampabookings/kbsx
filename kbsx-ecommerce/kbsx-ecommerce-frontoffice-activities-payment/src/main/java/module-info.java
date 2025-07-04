// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.ecommerce.frontoffice.activities.payment {

    // Direct dependencies modules
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.ecommerce.frontoffice.activities.cart.routing;
    requires kbsx.event.client.sectionpanel;
    requires modality.base.client.entities;
    requires modality.base.client.util;
    requires modality.base.shared.domainmodel;
    requires modality.base.shared.entities;
    requires webfx.extras.action;
    requires webfx.extras.i18n;
    requires webfx.extras.util.control;
    requires webfx.extras.util.dialog;
    requires webfx.extras.util.layout;
    requires webfx.extras.webtext;
    requires webfx.kit.util;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.util;
    requires webfx.platform.util.time;
    requires webfx.platform.windowhistory;
    requires webfx.platform.windowlocation;
    requires webfx.stack.hash.sha1;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity;
    requires webfx.stack.routing.uirouter;
    requires webfx.stack.session.state.client.fx;

    // Exported packages
    exports org.kadampabookings.kbsx.ecommerce.frontoffice.activities.payment;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.ecommerce.frontoffice.activities.payment.PaymentRouting.PaymentUiRoute;

}