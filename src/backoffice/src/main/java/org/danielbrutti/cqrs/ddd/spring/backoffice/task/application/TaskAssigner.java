package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskAssigner {

    private TaskFinder finder;
    private TaskRepository repository;
    private DomainEventPublisher publisher;

    public TaskAssigner(TaskFinder finder, TaskRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }

    public void assign(TaskId taskId, DeveloperId developerId) {
        Task task = finder.find(taskId);

        task.assign(developerId);

        this.repository.save(task);

        this.publisher.publish(task.pullDomainEvents());
    }
}
