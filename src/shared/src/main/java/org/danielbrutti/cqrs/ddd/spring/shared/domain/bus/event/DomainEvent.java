package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.InmutableDateTimeVO;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class DomainEvent {

    private String eventId;
    private String aggregateId;
    private InmutableDateTimeVO ocurredOn;
    private Map<String, Object> data;

    public DomainEvent(String aggregateId, Map<String, Object> data) {
        this.aggregateId = aggregateId;
        this.data = data;
        this.eventId = UuidVO.random().toString();
        this.ocurredOn = new InmutableDateTimeVO(LocalDateTime.now());
    }

    public String getEventId() {
        return eventId;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public InmutableDateTimeVO getOcurredOn() {
        return ocurredOn;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public abstract String getEventName();

}
