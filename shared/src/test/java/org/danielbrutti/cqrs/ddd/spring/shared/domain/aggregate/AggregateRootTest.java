package org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
import static org.junit.Assert.*;
import org.junit.Test;

public final class AggregateRootTest {

    @Test
    public void aggregate_root_create() {
        AggregateRoot aggregateRoot = new AggregateRoot() {
        };
        aggregateRoot.record(new DomainEvent(UuidVO.random().toString()) {
            @Override
            public String getEventName() {
                return "aggregate.root.event";
            }
        });
        assertNotNull(aggregateRoot.pullDomainEvents());
        assertEquals(0, aggregateRoot.pullDomainEvents().size());
    }
}
