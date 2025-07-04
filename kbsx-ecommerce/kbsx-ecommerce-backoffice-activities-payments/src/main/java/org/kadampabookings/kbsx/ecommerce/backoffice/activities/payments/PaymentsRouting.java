package org.kadampabookings.kbsx.ecommerce.backoffice.activities.payments;

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
import one.modality.base.client.util.routing.ModalityRoutingUtil;

/**
 * @author Bruno Salmon
 */
public final class PaymentsRouting {

    private final static String PATH = "/payments/event/:eventId";
    private final static String OPERATION_CODE = "RouteToPayments";

    public static String getPath() {
        return PATH;
    }

    public static String getPaymentsPath(Object eventId) {
        return ModalityRoutingUtil.interpolateEventIdInPath(eventId, PATH);
    }

    public static final class PaymentsUiRoute extends UiRouteImpl {

        public PaymentsUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(PathBuilder.toRegexPath(PaymentsRouting.getPath())
                    , true
                    , PaymentsActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToPaymentsRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToPaymentsRequest(Object eventId, BrowsingHistory history) {
            super(getPaymentsPath(eventId), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToPaymentsRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToPaymentsRequest(context.getParameter("eventId"), context.getHistory());
        }
    }
}
