package com.jarilla.cqrs.ddd.spring.backoffice.task.application;

import com.jarilla.cqrs.ddd.spring.backoffice.task.domain.*;
import com.jarilla.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
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

        TaskId id = new TaskId(UuidVO.random().value());
        TaskType type = new TaskType("Story");
        TaskTitle title = new TaskTitle("Task Title");
        TaskPriority priority = new TaskPriority(3);
        TaskDescription description = new TaskDescription("Something to do");
        TaskCreationDate creationDate = new TaskCreationDate(LocalDateTime.now());

        taskCreator.create(id, type, title, priority, description, creationDate);

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());

    }
}
