// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.hotel.backoffice.activities.roomsgraphic {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires modality.base.backoffice.masterslave;
    requires modality.base.client.gantt.fx;
    requires modality.base.client.mainframe.fx;
    requires modality.base.client.presentationmodel;
    requires modality.base.client.util;
    requires modality.base.shared.entities;
    requires modality.event.client.activity.eventdependent;
    requires modality.hotel.backoffice.operations.resourceconfiguration;
    requires webfx.extras.action;
    requires webfx.extras.imagestore;
    requires webfx.extras.operation;
    requires webfx.extras.operation.action;
    requires webfx.extras.panes;
    requires webfx.extras.util.control;
    requires webfx.extras.util.layout;
    requires webfx.extras.visual.grid;
    requires webfx.platform.ast;
    requires webfx.platform.ast.json.plugin;
    requires webfx.platform.windowhistory;
    requires webfx.stack.com.serial;
    requires webfx.stack.db.datascope;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql;
    requires webfx.stack.orm.entity;
    requires webfx.stack.orm.reactive.entities;
    requires webfx.stack.orm.reactive.visual;
    requires webfx.stack.routing.router;
    requires webfx.stack.routing.router.client;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.hotel.backoffice.activities.roomsgraphic;

    // Provided services
    provides dev.webfx.stack.routing.uirouter.UiRoute with org.kadampabookings.kbsx.hotel.backoffice.activities.roomsgraphic.RoomsGraphicRouting.RoomsGraphicUiRoute;
    provides dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter with org.kadampabookings.kbsx.hotel.backoffice.activities.roomsgraphic.RoomsGraphicRouting.RouteToRoomsGraphicRequestEmitter;

}