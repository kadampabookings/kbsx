package org.kadampabookings.kbsx.crm.backoffice.activities.organizations;

import dev.webfx.platform.windowhistory.spi.BrowsingHistory;
import dev.webfx.stack.orm.domainmodel.activity.domainpresentation.impl.DomainPresentationActivityContextFinal;
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
public final class OrganizationsRouting {

    private final static String PATH = "/organizations";
    private final static String OPERATION_CODE = "RouteToOrganizations";

    public static String getPath() {
        return PATH;
    }

    public static final class OrganizationsUiRoute extends UiRouteImpl {

        public OrganizationsUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.create(OrganizationsRouting.getPath()
                    , true
                    , OrganizationsActivity::new
                    , DomainPresentationActivityContextFinal::new
            );
        }
    }

    public static final class RouteToOrganizationsRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToOrganizationsRequest(BrowsingHistory history) {
            super(getPath(), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToOrganizationsRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToOrganizationsRequest(context.getHistory());
        }
    }
}
