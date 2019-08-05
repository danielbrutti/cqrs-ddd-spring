package com.jarilla.cqrs.ddd.spring.shared.domain.bus.event;

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

    /**
     * Record an event to be published in the future
     * @see DomainEventPublisher::publishRecordedEvents
     * @param domainEvents Events to be recorded
     */
    void record(Set<DomainEvent> domainEvents);

    /**
     * Record an event to be published in the future
     * @see DomainEventPublisher::publishRecordedEvents
     * @param domainEvent Event to be recorded
     */
    void record(DomainEvent domainEvent);

    /**
     * Publish all recorded events
     */
    void publishRecordedEvents();
}
