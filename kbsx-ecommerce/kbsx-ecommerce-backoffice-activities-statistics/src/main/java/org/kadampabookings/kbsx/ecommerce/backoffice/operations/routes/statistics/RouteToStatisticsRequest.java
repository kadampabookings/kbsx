package org.kadampabookings.kbsx.ecommerce.backoffice.operations.routes.statistics;

import org.kadampabookings.kbsx.ecommerce.backoffice.activities.statistics.routing.StatisticsRouting;
import dev.webfx.stack.routing.uirouter.operations.RoutePushRequest;
import dev.webfx.stack.ui.operation.HasOperationCode;
import dev.webfx.platform.windowhistory.spi.BrowsingHistory;

/**
 * @author Bruno Salmon
 */
public final class RouteToStatisticsRequest extends RoutePushRequest implements HasOperationCode {

    private final static String OPERATION_CODE = "RouteToStatistics";

    public RouteToStatisticsRequest(Object eventId, BrowsingHistory history) {
        super(StatisticsRouting.getEventStatisticsPath(eventId), history);
    }

    @Override
    public Object getOperationCode() {
        return OPERATION_CODE;
    }

}
