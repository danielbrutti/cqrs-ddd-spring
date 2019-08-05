package com.jarilla.cqrs.ddd.spring.backoffice.task.application;

import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.*;
import com.jarilla.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class TaskUpdater {

    private TaskRepository repository;
    private TaskFinder taskFinder;
    private DomainEventPublisher publisher;

    public TaskUpdater(TaskRepository repository, TaskFinder taskFinder, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    public void update(Task updated) {
        Task existent = taskFinder.find(updated.getTaskId());

        existent.update(updated);

        this.repository.save(existent);

        this.publisher.publish(existent.pullDomainEvents());
    }
}
