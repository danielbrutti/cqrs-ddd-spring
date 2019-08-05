package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public final class CreateTaskTest {

    private TaskRepository repository;
    private DomainEventPublisher publisher;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        publisher = mock(DomainEventPublisher.class);

        doNothing().when(repository).save(any());
        doNothing().when(publisher).publish(anySet());

    }

    @Test
    void should_create_task() {

        TaskCreator taskCreator = new TaskCreator(repository, publisher);

        TaskId id = TaskStub.randomTaskId();
        TaskType type = TaskStub.randomType();
        TaskTitle title = TaskStub.randomTitle();
        TaskPriority priority = TaskStub.randomPriority();
        TaskDescription description = TaskStub.randomDescription();
        TaskCreationDate creationDate = TaskStub.randomCreationDate();

        taskCreator.create(id, type, title, priority, description, creationDate);

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());

    }
}
