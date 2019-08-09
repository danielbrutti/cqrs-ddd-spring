package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskUnassigner {

    private TaskFinder finder;
    private TaskRepository repository;
    private DomainEventPublisher publisher;

    public TaskUnassigner(TaskFinder finder, TaskRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }

    public void unassign(TaskId taskId) {
        Task task = finder.find(taskId);

        task.unassign();

        this.repository.save(task);

        this.publisher.publish(task.pullDomainEvents());
    }
}
