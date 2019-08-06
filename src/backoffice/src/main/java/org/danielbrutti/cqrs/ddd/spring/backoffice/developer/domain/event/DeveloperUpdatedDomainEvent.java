package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class DeveloperUpdatedDomainEvent extends DomainEvent {

    public DeveloperUpdatedDomainEvent(String aggregateId, Map<String, Object> data) {
        super(aggregateId, data);
    }

    @Override
    public String getEventName() {
        return DeveloperUpdatedDomainEvent.class.getCanonicalName();
    }
}
