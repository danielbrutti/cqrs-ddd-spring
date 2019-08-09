package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

public interface DomainEventListener<Event extends DomainEvent> {

    void subscribe();

    void process(Event event);
}
