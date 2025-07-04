// File managed by WebFX (DO NOT EDIT MANUALLY)

module kbsx.ecommerce.backoffice.operations.newbooking {

    // Direct dependencies modules
    requires kbsx.base.client.aggregates;
    requires kbsx.event.frontoffice.activities.fees;
    requires webfx.extras.operation;
    requires webfx.platform.async;
    requires webfx.platform.windowhistory;
    requires webfx.stack.routing.uirouter;

    // Exported packages
    exports org.kadampabookings.kbsx.operations.routes.newbooking;

}