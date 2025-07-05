// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.ecommerce.frontoffice.activities.cart {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.ecommerce.client.bookingoptionspanel;
    requires kbsx.ecommerce.client.businesslogic;
    requires kbsx.ecommerce.frontoffice.activities.cart.routing;
    requires kbsx.ecommerce.frontoffice.activities.contactus;
    requires kbsx.ecommerce.frontoffice.activities.payment;
    requires kbsx.event.client.sectionpanel;
    requires kbsx.event.frontoffice.activities.options;
    requires kbsx.event.frontoffice.activities.startbooking;
    requires modality.base.client.util;
    requires modality.base.shared.domainmodel;
    requires modality.base.shared.entities;
    requires webfx.extras.action;
    requires webfx.extras.i18n;
    requires webfx.extras.panes;
    requires webfx.extras.type;
    requires webfx.extras.util.control;
    requires webfx.extras.util.dialog;
    requires webfx.extras.util.layout;
    requires webfx.extras.visual;
    requires webfx.extras.visual.grid;
    requires webfx.kit.util;
    requires webfx.platform.async;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.util;
    requires webfx.stack.orm.domainmodel;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity;
    requires webfx.stack.orm.expression;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.ecommerce.frontoffice.activities.cart;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.ecommerce.frontoffice.activities.cart.CartUiRoute;

}