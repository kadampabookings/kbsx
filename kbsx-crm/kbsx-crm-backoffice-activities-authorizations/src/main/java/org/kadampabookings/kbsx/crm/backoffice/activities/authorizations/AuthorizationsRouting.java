package org.kadampabookings.kbsx.crm.backoffice.activities.authorizations;

import dev.webfx.platform.windowhistory.spi.BrowsingHistory;
import dev.webfx.stack.orm.domainmodel.activity.viewdomain.impl.ViewDomainActivityContextFinal;
import dev.webfx.stack.routing.router.auth.authz.RouteRequest;
import dev.webfx.stack.routing.uirouter.UiRoute;
import dev.webfx.stack.routing.uirouter.activity.uiroute.UiRouteActivityContext;
import dev.webfx.stack.routing.uirouter.impl.UiRouteImpl;
import dev.webfx.stack.routing.uirouter.operations.RoutePushRequest;
import dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter;
import dev.webfx.extras.operation.HasOperationCode;

/**
 * @author Bruno Salmon
 */
public final class AuthorizationsRouting {

    private static final String PATH = "/authorizations";
    private final static String OPERATION_CODE = "RouteToAuthorizations";

    public static String getPath() {
        return PATH;
    }

    public static final class AuthorizationsUiRoute extends UiRouteImpl {

        public AuthorizationsUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.create(AuthorizationsRouting.getPath()
                    , true
                    , AuthorizationsActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToAuthorizationsRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToAuthorizationsRequest(BrowsingHistory history) {
            super(getPath(), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToAuthorizationsRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToAuthorizationsRequest(context.getHistory());
        }
    }
}
