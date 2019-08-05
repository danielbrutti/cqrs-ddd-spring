package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

public interface DomainEventBus {

    /**
     * Publish an event immediately
     *
     * @param domainEvent Event to publish on Bus
     */
    void publish(DomainEvent domainEvent);

}
