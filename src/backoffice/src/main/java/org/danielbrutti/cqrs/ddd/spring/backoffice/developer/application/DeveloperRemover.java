package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperRemover {

    private TaskRepository repository;
    private TaskFinder finder;
    private DomainEventPublisher publisher;

    public DeveloperRemover(TaskFinder finder, TaskRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }


    public void delete(TaskId id) {
        Task task = finder.find(id);
        task.delete();

        this.repository.delete(id);

        this.publisher.publish(task.pullDomainEvents());
    }
}
