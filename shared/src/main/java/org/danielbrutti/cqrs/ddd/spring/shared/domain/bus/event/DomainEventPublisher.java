package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

import java.util.Set;

public interface DomainEventPublisher {

    /**
     * Publish an event immediately
     * @param domainEvent Event to be published
     */
    void publish(DomainEvent domainEvent);

    /**
     * Publish a set of events immediately
     * @param domainEvents Events to be published
     */
    void publish(Set<DomainEvent> domainEvents);
}
