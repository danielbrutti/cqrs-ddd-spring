package org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event;

public interface DomainEventSubscriber {
    void subscribe(DomainEventListener listener, Class eventClass);
}
