package org.kadampabookings.kbsx.crm.backoffice.activities.authorizations;

import org.kadampabookings.kbsx.crm.backoffice.activities.operations.authorizations.RouteToAuthorizationsRequest;
import dev.webfx.stack.routing.uirouter.activity.uiroute.UiRouteActivityContext;
import dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter;
import dev.webfx.stack.routing.router.auth.authz.RouteRequest;

/**
 * @author Bruno Salmon
 */
public final class RouteToAuthorizationsRequestEmitter implements RouteRequestEmitter {

    @Override
    public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
        return new RouteToAuthorizationsRequest(context.getHistory());
    }
}
