package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class DeveloperDeletedDomainEvent extends DomainEvent {

    public DeveloperDeletedDomainEvent(String aggregateId, Map<String, Object> data) {
        super(aggregateId, data);
    }

    @Override
    public String getEventName() {
        return DeveloperDeletedDomainEvent.class.getCanonicalName();
    }
}
