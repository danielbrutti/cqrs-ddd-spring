package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public final class DeleteTaskTest {

    private TaskRepository repository;
    private TaskFinder finder;
    private DomainEventPublisher publisher;

    private static Task task;

    @BeforeEach
    void setUp() {
        task = TaskStub.random();

        repository = mock(TaskRepository.class);
        publisher = mock(DomainEventPublisher.class);
        finder = mock(TaskFinder.class);

        doNothing().when(repository).save(any());
        doNothing().when(publisher).publish(anySet());
        when(finder.find(any())).thenReturn(task);
    }

    @Test
    void should_delete_task() {

        TaskDeleter taskDeleter = new TaskDeleter(finder, repository, publisher);

        TaskId taskId = task.getTaskId();

        taskDeleter.delete(taskId);

        verify(repository, times(1)).delete(taskId);
        verify(publisher, times(1)).publish(anySet());

    }
}
