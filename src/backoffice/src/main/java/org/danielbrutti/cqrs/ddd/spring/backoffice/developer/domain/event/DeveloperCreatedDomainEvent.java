package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class DeveloperCreatedDomainEvent extends DomainEvent {

    public DeveloperCreatedDomainEvent(String aggregateId, Map<String, Object> data) {
        super(aggregateId, data);
    }

    @Override
    public String getEventName() {
        return DeveloperCreatedDomainEvent.class.getCanonicalName();
    }
}
