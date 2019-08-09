package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

public final class DeveloperUpdatedDomainEvent extends DomainEvent {

    public DeveloperUpdatedDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    @Override
    public String getEventName() {
        return "org.danielbrutti.developer.updated";
    }
}
