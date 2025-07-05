package org.kadampabookings.kbsx.hotel.backoffice.activities.roomsgraphic;

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
public final class RoomsGraphicRouting {

    private final static String ANY_PATH = "/rooms-graphic(/event/:eventId)?";
    private final static String EVENT_PATH = "/rooms-graphic/event/:eventId";
    private final static String OPERATION_CODE = "RouteToRoomsGraphic";

    public static String getAnyPath() {
        return ANY_PATH;
    }

    public static String getEventPath(Object eventId) {
        return eventId == null ? "/rooms-graphic" : ModalityRoutingUtil.interpolateEventIdInPath(eventId, EVENT_PATH);
    }

    public static final class RoomsGraphicUiRoute extends UiRouteImpl {

        public RoomsGraphicUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(PathBuilder.toRegexPath(getAnyPath())
                    , true
                    , RoomsGraphicActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToRoomsGraphicRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToRoomsGraphicRequest(Object eventId, BrowsingHistory history) {
            super(getEventPath(eventId), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToRoomsGraphicRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToRoomsGraphicRequest(context.getParameter("eventId"), context.getHistory());
        }
    }
}
