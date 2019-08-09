package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class TaskAssignedDomainEvent extends DomainEvent {

    private String developerId;

    public TaskAssignedDomainEvent(String aggregateId, String developerId) {
        super(aggregateId);
        this.developerId = developerId;
    }

    @Override
    public String getEventName() {
        return "org.danielbrutti.task.assigned";
    }

    public String getDeveloperId() {
        return developerId;
    }
}
