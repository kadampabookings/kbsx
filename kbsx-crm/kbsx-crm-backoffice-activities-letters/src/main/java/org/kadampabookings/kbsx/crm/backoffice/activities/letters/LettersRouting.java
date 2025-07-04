package org.kadampabookings.kbsx.crm.backoffice.activities.letters;

import dev.webfx.platform.windowhistory.spi.BrowsingHistory;
import dev.webfx.stack.orm.domainmodel.activity.domainpresentation.impl.DomainPresentationActivityContextFinal;
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
public final class LettersRouting {

    private static final String ANY_PATH = "/letters(/organization/:organizationId)?(/event/:eventId)?";
    private static final String EVENT_PATH = "/letters/event/:eventId";
    private final static String OPERATION_CODE = "RouteToLetters";

    public static String getAnyPath() {
        return ANY_PATH;
    }

    public static String getEventLettersPath(Object eventId) {
        return eventId == null ? "/letters" : ModalityRoutingUtil.interpolateEventIdInPath(eventId, EVENT_PATH);
    }

    public static final class LettersUiRoute extends UiRouteImpl {

        public LettersUiRoute() {
            super(uiRoute());
        }

        public static UiRoute<?> uiRoute() {
            return UiRoute.createRegex(
                    PathBuilder.toRegexPath(getAnyPath())
                    , true
                    , LettersActivity::new
                    , DomainPresentationActivityContextFinal::new
            );
        }
    }

    public static final class RouteToLettersRequest extends RoutePushRequest implements HasOperationCode {

        public RouteToLettersRequest(Object eventId, BrowsingHistory history) {
            super(getEventLettersPath(eventId), history);
        }

        @Override
        public Object getOperationCode() {
            return OPERATION_CODE;
        }

    }

    public static final class RouteToLettersRequestEmitter implements RouteRequestEmitter {

        @Override
        public RouteRequest instantiateRouteRequest(UiRouteActivityContext context) {
            return new RouteToLettersRequest(context.getParameter("eventId"), context.getHistory());
        }
    }
}
