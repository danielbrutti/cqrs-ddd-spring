package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

public final class TaskClosedDomainEvent extends DomainEvent {

    private String developerId;

    public TaskClosedDomainEvent(String aggregateId, String developerId) {
        super(aggregateId);
        this.developerId = developerId;
    }

    @Override
    public String getEventName() {
        return "org.danielbrutti.task.closed";
    }

    public String getDeveloperId() {
        return developerId;
    }
}
