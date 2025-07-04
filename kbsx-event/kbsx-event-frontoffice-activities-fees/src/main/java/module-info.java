// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.event.frontoffice.activities.fees {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires kbsx.base.client.aggregates;
    requires kbsx.base.client.icons;
    requires kbsx.base.shared.entities;
    requires kbsx.ecommerce.client.bookingprocess;
    requires kbsx.ecommerce.client.businesslogic;
    requires kbsx.event.client.sectionpanel;
    requires kbsx.event.frontoffice.activities.options;
    requires modality.base.client.activity;
    requires modality.base.client.entities;
    requires modality.base.client.util;
    requires modality.base.shared.entities;
    requires webfx.extras.cell;
    requires webfx.extras.i18n;
    requires webfx.extras.i18n.controls;
    requires webfx.extras.imagestore;
    requires webfx.extras.jsonimage;
    requires webfx.extras.type;
    requires webfx.extras.visual;
    requires webfx.extras.visual.grid;
    requires webfx.kit.util;
    requires webfx.platform.ast;
    requires webfx.platform.ast.json.plugin;
    requires webfx.platform.console;
    requires webfx.platform.uischeduler;
    requires webfx.platform.util;
    requires webfx.platform.windowhistory;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.entity;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.event.frontoffice.activities.fees;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.event.frontoffice.activities.fees.FeesRouting.FeesUiRoute;

}