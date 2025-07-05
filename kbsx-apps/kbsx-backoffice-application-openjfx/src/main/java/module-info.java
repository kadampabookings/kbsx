// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.backoffice.application.openjfx {

    // Direct dependencies modules
    requires javafx.controls;
    requires javafx.web;
    requires kbsx.backoffice.application;
    requires kbsx.event.backoffice.activities.cloneevent;
    requires kbsx.event.backoffice.activities.cloneevent.routing;
    requires modality.ecommerce.document.service.buscall;
    requires modality.ecommerce.document.service.remote;
    requires modality.ecommerce.payment.buscall;
    requires modality.ecommerce.payment.remote;
    requires webfx.extras.fxraiser.json;
    requires webfx.extras.time.format;
    requires webfx.extras.visual.charts.peers.openjfx;
    requires webfx.extras.visual.grid.peers.openjfx;
    requires webfx.extras.webtext.peers.openjfx;
    requires webfx.kit.javafxgraphics.openjfx;
    requires webfx.kit.platform.visibility.openjfx;
    requires webfx.platform.ast.factory.generic;
    requires webfx.platform.boot.java;
    requires webfx.platform.console.java;
    requires webfx.platform.os.java;
    requires webfx.platform.resource.java;
    requires webfx.platform.scheduler.java;
    requires webfx.platform.shutdown.java;
    requires webfx.platform.storage.java;
    requires webfx.platform.storagelocation.java;
    requires webfx.platform.useragent.java.client;
    requires webfx.platform.windowhistory.java;
    requires webfx.platform.windowlocation.java;
    requires webfx.stack.authn.buscall;
    requires webfx.stack.authn.login.ui.portal;
    requires webfx.stack.authn.remote;
    requires webfx.stack.com.bus.json.client;
    requires webfx.stack.com.bus.json.client.websocket.java;
    requires webfx.stack.com.websocket.java;
    requires webfx.stack.db.query.buscall;
    requires webfx.stack.db.querypush.buscall;
    requires webfx.stack.db.querypush.client.simple;
    requires webfx.stack.db.querysubmit.java.jdbc;
    requires webfx.stack.db.submit.buscall;
    requires webfx.stack.orm.domainmodel.activity;
    requires webfx.stack.orm.dql.query.interceptor;
    requires webfx.stack.orm.dql.querypush.interceptor;
    requires webfx.stack.orm.dql.submit.interceptor;
    requires webfx.stack.push.client.simple;
    requires webfx.stack.routing.uirouter;
    requires webfx.stack.session.client;

    // Exported packages
    exports org.kadampabookings.kbsx.backoffice.activities.event.clone.openjfx;

}