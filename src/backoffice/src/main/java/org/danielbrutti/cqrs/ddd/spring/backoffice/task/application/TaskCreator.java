package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskCreator {

    private TaskRepository repository;
    private DomainEventPublisher publisher;

    public TaskCreator(TaskRepository repository, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    public void create(TaskId id, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDate creationDate) {
        Task task = Task.create(id, type, title, priority, description, creationDate);

        this.repository.save(task);

        this.publisher.publish(task.pullDomainEvents());
    }
}
