package org.kadampabookings.kbsx.crm.backoffice.activities.users;

import dev.webfx.platform.windowhistory.spi.BrowsingHistory;
import dev.webfx.stack.orm.domainmodel.activity.viewdomain.impl.ViewDomainActivityContextFinal;
import dev.webfx.stack.routing.router.auth.authz.RouteRequest;
import dev.webfx.stack.routing.router.util.PathBuilder;
import dev.webfx.stack.routing.uirouter.UiRoute;
import dev.webfx.stack.routing.uirouter.activity.uiroute.UiRouteActivityContext;
import dev.webfx.stack.routing.uirouter.impl.UiRouteImpl;
import dev.webfx.stack.routing.uirouter.operations.RoutePushRequest;
import dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter;
import dev.webfx.extras.operation.HasOperationCode;

/**
 * @author Bruno Salmon
 */
public final class UsersRouting {

    private final static String PATH = "/users";
    private final static String OPERATION_CODE = "RouteToUsers";

    public static String getPath() {
        return PATH;
    }

    public static final class UsersUiRoute extends UiRouteImpl {

        public UsersUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(PathBuilder.toRegexPath(UsersRouting.getPath())
                    , true
                    , UsersActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToUsersRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToUsersRequest(BrowsingHistory history) {
            super(getPath(), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToUsersRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToUsersRequest(context.getHistory());
        }
    }
}
