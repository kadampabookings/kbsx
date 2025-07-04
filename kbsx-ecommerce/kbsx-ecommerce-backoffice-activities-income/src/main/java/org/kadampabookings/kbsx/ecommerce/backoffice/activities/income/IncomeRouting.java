package org.kadampabookings.kbsx.ecommerce.backoffice.activities.income;

import dev.webfx.platform.windowhistory.spi.BrowsingHistory;
import dev.webfx.stack.orm.domainmodel.activity.viewdomain.impl.ViewDomainActivityContextFinal;
import dev.webfx.stack.routing.router.auth.authz.RouteRequest;
import dev.webfx.stack.routing.uirouter.UiRoute;
import dev.webfx.stack.routing.uirouter.activity.uiroute.UiRouteActivityContext;
import dev.webfx.stack.routing.uirouter.impl.UiRouteImpl;
import dev.webfx.stack.routing.uirouter.operations.RoutePushRequest;
import dev.webfx.stack.routing.uirouter.operations.RouteRequestEmitter;
import dev.webfx.extras.operation.HasOperationCode;
import one.modality.base.client.util.routing.ModalityRoutingUtil;

/**
 * @author Bruno Salmon
 */
public final class IncomeRouting {

    private final static String PATH = "/income/event/:eventId";
    private final static String OPERATION_CODE = "RouteToIncome";

    public static String getPath() {
        return PATH;
    }

    public static String getEventIncomePath(Object eventId) {
        return ModalityRoutingUtil.interpolateEventIdInPath(eventId, PATH);
    }

    public static final class IncomeUiRoute extends UiRouteImpl {

        public IncomeUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.create(IncomeRouting.getPath()
                    , true
                    , IncomeActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToIncomeRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToIncomeRequest(Object eventId, BrowsingHistory history) {
            super(getEventIncomePath(eventId), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToIncomeRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToIncomeRequest(context.getParameter("eventId"), context.getHistory());
        }
    }
}
