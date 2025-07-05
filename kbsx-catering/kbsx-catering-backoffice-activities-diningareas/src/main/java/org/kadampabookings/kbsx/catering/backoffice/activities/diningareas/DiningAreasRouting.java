package org.kadampabookings.kbsx.catering.backoffice.activities.diningareas;

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
public final class DiningAreasRouting {

    private final static String PATH = "/dining-areas/event/:eventId";
    private final static String OPERATION_CODE = "RouteToDiningAreas";

    public static String getPath() {
        return PATH;
    }

    public static String getEventPath(Object eventId) {
        return ModalityRoutingUtil.interpolateEventIdInPath(eventId, PATH);
    }

    public static final class DiningAreasUiRoute extends UiRouteImpl {

        public DiningAreasUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(PathBuilder.toRegexPath(DiningAreasRouting.getPath())
                    , true
                    , DiningAreasActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToDiningAreasRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToDiningAreasRequest(Object eventId, BrowsingHistory history) {
            super(getEventPath(eventId), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToDiningAreasRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToDiningAreasRequest(context.getParameter("eventId"), context.getHistory());
        }
    }
}
