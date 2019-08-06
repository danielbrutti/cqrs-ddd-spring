package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class TaskAssignedDomainEvent extends DomainEvent {

    public TaskAssignedDomainEvent(String aggregateId, Map<String, Object> data) {
        super(aggregateId, data);
    }

    @Override
    public String getEventName() {
        return TaskAssignedDomainEvent.class.getCanonicalName();
    }
}
