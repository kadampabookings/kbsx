package org.kadampabookings.kbsx.ecommerce.client.businessdata.preselection;

import org.kadampabookings.kbsx.base.client.aggregates.event.EventAggregate;
import one.modality.base.shared.entities.Event;
import dev.webfx.stack.orm.entity.EntityId;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class ActiveOptionsPreselectionsByEventStore {

    private final static Map<EntityId, OptionsPreselection> activeOptionsPreselectionsByEventMap = new HashMap<>();

    public static void setActiveOptionsPreselection(OptionsPreselection activeOptionsPreselection, EventAggregate eventAggregate) {
        setActiveOptionsPreselection(activeOptionsPreselection, eventAggregate.getEvent());
    }

    public static void setActiveOptionsPreselection(OptionsPreselection activeOptionsPreselection, Event event) {
        setActiveOptionsPreselection(activeOptionsPreselection, event.getId());
    }

    public static void setActiveOptionsPreselection(OptionsPreselection selectedOptionsPreselection, EntityId eventId) {
        activeOptionsPreselectionsByEventMap.put(eventId, selectedOptionsPreselection);
    }

    public static OptionsPreselection getActiveOptionsPreselection(EventAggregate eventAggregate) {
        return getActiveOptionsPreselection(eventAggregate.getEvent());
    }

    public static OptionsPreselection getActiveOptionsPreselection(Event event) {
        return getActiveOptionsPreselection(event.getId());
    }

    public static OptionsPreselection getActiveOptionsPreselection(EntityId eventId) {
        return activeOptionsPreselectionsByEventMap.get(eventId);
    }
}
