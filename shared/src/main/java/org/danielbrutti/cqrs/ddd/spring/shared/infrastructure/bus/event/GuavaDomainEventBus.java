package org.danielbrutti.cqrs.ddd.spring.shared.infrastructure.bus.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventListener;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventSubscriber;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public final class GuavaDomainEventBus implements DomainEventPublisher, DomainEventSubscriber {

    private final Map<String, AsyncEventBus> eventBus;

    public GuavaDomainEventBus() {
        this.eventBus = Collections.synchronizedMap(new HashMap<>());
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        AsyncEventBus bus = getEventBus(domainEvent.getClass());
        bus.post(domainEvent);
    }

    @Override
    public void publish(Set<DomainEvent> domainEvents) {
        domainEvents.forEach(domainEvent -> this.publish(domainEvent));
    }

    @Override
    public void subscribe(DomainEventListener listener, Class eventClass) {
        AsyncEventBus bus = getEventBus(eventClass);
        bus.register(new Consumer<DomainEvent>() {
            @Override
            @Subscribe
            public void accept(DomainEvent domainEvent) {
                listener.process(domainEvent);
            }
        });
    }

    private AsyncEventBus getEventBus(Class domainEventClass) {
        AsyncEventBus bus = this.eventBus.get(domainEventClass.getName());
        if (bus == null) {
            bus = new AsyncEventBus(domainEventClass.getName(), Executors.newFixedThreadPool(10));
            this.eventBus.put(domainEventClass.getName(), bus);
        }
        return bus;
    }
}
