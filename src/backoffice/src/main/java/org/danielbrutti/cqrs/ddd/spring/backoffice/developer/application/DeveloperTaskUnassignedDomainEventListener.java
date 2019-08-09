package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event.TaskUnassignedDomainEvent;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventListener;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventSubscriber;

public final class DeveloperTaskUnassignedDomainEventListener implements DomainEventListener<TaskUnassignedDomainEvent> {

    private DeveloperTaskUnassigner taskUnassigner;
    private DomainEventSubscriber domainEventSubscriber;

    public DeveloperTaskUnassignedDomainEventListener(DeveloperTaskUnassigner taskUnassigner, DomainEventSubscriber domainEventSubscriber) {
        this.taskUnassigner = taskUnassigner;
        this.domainEventSubscriber = domainEventSubscriber;
        this.subscribe();
    }

    @Override
    public void subscribe() {
        this.domainEventSubscriber.subscribe(this, TaskUnassignedDomainEvent.class);
    }

    @Override
    public void process(TaskUnassignedDomainEvent event) {
        DeveloperId developerId = new DeveloperId(event.getDeveloperId());
        taskUnassigner.unassign(developerId);
    }

}
