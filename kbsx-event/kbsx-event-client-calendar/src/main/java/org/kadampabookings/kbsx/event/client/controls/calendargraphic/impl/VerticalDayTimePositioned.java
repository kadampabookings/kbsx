package org.kadampabookings.kbsx.event.client.controls.calendargraphic.impl;

import org.kadampabookings.kbsx.event.client.controls.calendargraphic.HasDayTimeMinuteInterval;

/**
 * @author Bruno Salmon
 */
interface VerticalDayTimePositioned extends HasDayTimeMinuteInterval {

    void setYAndHeight(double y, double height);
}
