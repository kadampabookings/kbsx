package org.kadampabookings.kbsx.base.shared.entities.impl;

import dev.webfx.platform.util.Objects;
import dev.webfx.stack.orm.entity.EntityId;
import dev.webfx.stack.orm.entity.EntityStore;
import dev.webfx.stack.orm.entity.impl.DynamicEntity;
import dev.webfx.stack.orm.entity.impl.EntityFactoryProviderImpl;
import org.kadampabookings.kbsx.base.shared.entities.Event;
import org.kadampabookings.kbsx.hotel.shared.businessdata.time.DateTimeRange;

import java.time.Clock;
import java.time.ZoneId;

/**
 * @author Bruno Salmon
 */
public final class EventImpl extends DynamicEntity implements Event {

    public EventImpl(EntityId id, EntityStore store) {
        super(id, store);
    }

    private DateTimeRange parsedDateTimeRange;
    @Override
    public DateTimeRange getParsedDateTimeRange() {
        if (parsedDateTimeRange == null)
            parsedDateTimeRange = DateTimeRange.parse(getDateTimeRange());
        return parsedDateTimeRange;
    }

    private DateTimeRange parsedMinDateTimeRange;
    @Override
    public DateTimeRange getParsedMinDateTimeRange() {
        if (parsedMinDateTimeRange == null)
            parsedMinDateTimeRange = DateTimeRange.parse(getMinDateTimeRange());
        return parsedMinDateTimeRange;
    }

    private DateTimeRange parsedMaxDateTimeRange;
    @Override
    public DateTimeRange getParsedMaxDateTimeRange() {
        if (parsedMaxDateTimeRange == null)
            parsedMaxDateTimeRange = DateTimeRange.parse(getMaxDateTimeRange());
        return parsedMaxDateTimeRange;
    }

    // Not used in KBSX
    @Override
    public ZoneId getEventZoneId() {
        return null;
    }

    @Override
    public Clock getEventClock() {
        return null;
    }

    public static final class ProvidedFactory extends EntityFactoryProviderImpl<one.modality.base.shared.entities.Event> {
        public ProvidedFactory() {
            super(one.modality.base.shared.entities.Event.class, EventImpl::new);
            // To make ReactiveDqlStatementAPI.ifInstanceOf() work with Event.class (see BookingsActivity)
            Objects.registerInstanceOf(one.modality.base.shared.entities.Event.class, o -> o instanceof one.modality.base.shared.entities.Event);
        }
    }
}
