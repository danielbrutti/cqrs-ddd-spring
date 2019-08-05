package org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.HashSet;
import java.util.Set;

public abstract class AggregateRoot {

    private Set<DomainEvent> domainEvents;

    public AggregateRoot() {
        this.domainEvents = new HashSet<>();
    }

    public Set<DomainEvent> pullDomainEvents() {
        Set<DomainEvent> copy = new HashSet<>(domainEvents);
        domainEvents.clear();
        return copy;
    }

    public void record(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }

}
