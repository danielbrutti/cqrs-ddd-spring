package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event.TaskAssignedDomainEvent;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventListener;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventSubscriber;

public final class DeveloperTaskAssignedDomainEventListener implements DomainEventListener<TaskAssignedDomainEvent> {

    private DeveloperTaskAssigner taskAssigner;
    private DomainEventSubscriber domainEventSubscriber;

    public DeveloperTaskAssignedDomainEventListener(DeveloperTaskAssigner taskAssigner, DomainEventSubscriber domainEventSubscriber) {
        this.taskAssigner = taskAssigner;
        this.domainEventSubscriber = domainEventSubscriber;
        this.subscribe();
    }

    @Override
    public void subscribe() {
        this.domainEventSubscriber.subscribe(this, TaskAssignedDomainEvent.class);
    }

    @Override
    public void process(TaskAssignedDomainEvent event) {

        DeveloperId developerId = new DeveloperId(event.getDeveloperId());
        taskAssigner.assign(developerId);
    }

}
