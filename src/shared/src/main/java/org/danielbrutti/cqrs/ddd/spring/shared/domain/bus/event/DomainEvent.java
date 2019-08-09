package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.ImmutableDateTimeVO;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.time.LocalDateTime;

public abstract class DomainEvent {

    private String eventId;
    private String aggregateId;
    private ImmutableDateTimeVO ocurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UuidVO.random().toString();
        this.ocurredOn = new ImmutableDateTimeVO(LocalDateTime.now());
    }

    public String getEventId() {
        return eventId;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public ImmutableDateTimeVO getOcurredOn() {
        return ocurredOn;
    }

    public abstract String getEventName();

}
