package org.kadampabookings.kbsx.event.backoffice.activities.events;

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
public final class EventsRouting {

    private final static String ANY_PATH = "/events(/organization/:organizationId)?";
    private final static String ALL_EVENTS_PATH = "/events";
    private final static String ORGANIZATION_PATH = "/events/organization/:organizationId";
    private final static String OPERATION_CODE = "RouteToEvents";


    public static String getAnyPath() {
        return ANY_PATH;
    }

    public static String getAllEventsPath() {
        return ALL_EVENTS_PATH;
    }

    public static String getOrganizationEventsPath(Object organizationId) {
        return ModalityRoutingUtil.interpolateOrganizationIdInPath(organizationId, ORGANIZATION_PATH);
    }

    public static final class EventsUiRoute extends UiRouteImpl {

        public EventsUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(
                    PathBuilder.toRegexPath(getAnyPath())
                    , true
                    , EventsActivity::new
                    , ViewDomainActivityContextFinal::new
            );
        }
    }

    public static final class RouteToEventsRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToEventsRequest(BrowsingHistory history) {
            super(getAllEventsPath(), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToEventsRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToEventsRequest(context.getHistory());
        }
    }
}
