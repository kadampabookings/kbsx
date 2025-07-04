package org.kadampabookings.kbsx.base.backoffice.activities.monitor;

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
public final class MonitorRouting {

    private final static String PATH = "/monitor";
    private final static String OPERATION_CODE = "RouteToMonitor";

    public static String getPath() {
        return PATH;
    }

    public static final class MonitorUiRoute extends UiRouteImpl {

        public MonitorUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.create(MonitorRouting.getPath()
                    , true
                    , MonitorActivity::new
                    , DomainPresentationActivityContextFinal::new
            );
        }
    }

    public static final class RouteToMonitorRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToMonitorRequest(BrowsingHistory history) {
            super(getPath(), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToMonitorRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToMonitorRequest(context.getHistory());
        }
    }
}
