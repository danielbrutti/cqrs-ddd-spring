package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class TaskCreatedDomainEvent extends DomainEvent {

    public TaskCreatedDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    @Override
    public String getEventName() {
        return "org.danielbrutti.task.created";
    }
}
