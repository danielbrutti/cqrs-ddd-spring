package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperUpdater {

    private TaskRepository repository;
    private TaskFinder finder;
    private DomainEventPublisher publisher;

    public DeveloperUpdater(TaskFinder finder, TaskRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }


    public void update(Task updated) {
        Task existent = finder.find(updated.getTaskId());

        existent.update(updated);

        this.repository.save(existent);

        this.publisher.publish(existent.pullDomainEvents());
    }
}
