package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class TaskCreatedDomainEvent extends DomainEvent {

    public TaskCreatedDomainEvent(String aggregateId, Map<String, Object> data) {
        super(aggregateId, data);
    }

    @Override
    public String getEventName() {
        return TaskCreatedDomainEvent.class.getCanonicalName();
    }
}
