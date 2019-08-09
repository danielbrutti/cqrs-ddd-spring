package org.danielbrutti.cqrs.ddd.spring.shared.infrastructure.bus.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventListener;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventSubscriber;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DomainEventBusTest {

    private GuavaDomainEventBus eventBus = new GuavaDomainEventBus();

    @Test
    public void should_publish_event() {
        SomeEventListener someEventListener = new SomeEventListener(eventBus);

        AnotherCoolEventListener anotherCoolEventListener = new AnotherCoolEventListener(eventBus);

        eventBus.publish(new SomeEvent());
        eventBus.publish(new SomeEvent());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        assertEquals(2, someEventListener.count.get());
        assertEquals(0, anotherCoolEventListener.count.get());
    }

    private final class SomeEventListener implements DomainEventListener<SomeEvent> {
        public AtomicInteger count = new AtomicInteger(0);

        private DomainEventSubscriber subscriber;

        public SomeEventListener(DomainEventSubscriber subscriber) {
            this.subscriber = subscriber;
            this.subscribe();
        }

        @Override
        public void subscribe() {
            subscriber.subscribe(this, SomeEvent.class);
        }

        @Override
        public void process(SomeEvent event) {
            count.incrementAndGet();
        }
    }

    private final class AnotherCoolEventListener implements DomainEventListener<AnotherCoolEvent> {
        public AtomicInteger count = new AtomicInteger(0);

        private DomainEventSubscriber subscriber;

        public AnotherCoolEventListener(DomainEventSubscriber subscriber) {
            this.subscriber = subscriber;
            this.subscribe();
        }

        @Override
        public void subscribe() {
            subscriber.subscribe(this, SomeEvent.class);
        }

        @Override
        public void process(AnotherCoolEvent event) {
            count.incrementAndGet();
        }
    }

    private final class SomeEvent extends DomainEvent {
        public SomeEvent() {
            super(UuidVO.random().toString());
        }

        @Override
        public String getEventName() {
            return "org.danielbrutti.some.event";
        }
    }

    private final class AnotherCoolEvent extends DomainEvent {
        public AnotherCoolEvent() {
            super(UuidVO.random().toString());
        }

        @Override
        public String getEventName() {
            return "org.danielbrutti.another.cool.event";
        }
    }
}
