package org.kadampabookings.kbsx.ecommerce.frontoffice.operations.person;

import org.kadampabookings.kbsx.ecommerce.frontoffice.activities.person.routing.PersonRouting;
import dev.webfx.stack.routing.uirouter.operations.RoutePushRequest;
import dev.webfx.platform.windowhistory.spi.BrowsingHistory;

/**
 * @author Bruno Salmon
 */
public final class RouteToPersonRequest extends RoutePushRequest {

    public RouteToPersonRequest(Object eventId, BrowsingHistory history) {
        super(PersonRouting.getPersonPath(eventId), history);
    }

}
