package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskCloser {

    private TaskFinder finder;
    private TaskRepository repository;
    private DomainEventPublisher publisher;

    public TaskCloser(TaskFinder finder, TaskRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }

    public void close(TaskId taskId) {
        Task task = finder.find(taskId);

        task.close();

        this.repository.save(task);

        this.publisher.publish(task.pullDomainEvents());
    }
}
