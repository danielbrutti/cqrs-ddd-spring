package com.jarilla.cqrs.ddd.spring.backoffice.task.application;

import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.Task;
import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import com.jarilla.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskDeleter {

    private TaskRepository repository;
    private TaskFinder taskFinder;
    private DomainEventPublisher publisher;

    public TaskDeleter(TaskRepository repository, TaskFinder taskFinder, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    public void delete(TaskId id) {
        Task task = taskFinder.find(id);
        task.delete();

        this.repository.delete(id);

        this.publisher.publish(task.pullDomainEvents());
    }
}
