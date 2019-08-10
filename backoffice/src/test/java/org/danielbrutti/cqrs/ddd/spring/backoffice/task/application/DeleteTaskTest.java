package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public final class DeleteTaskTest {

    private TaskRepository repository;
    private TaskFinder finder;
    private DomainEventPublisher publisher;

    private static Task task;

    @Before
    public void setUp() {
        task = spy(TaskStub.random());

        repository = mock(TaskRepository.class);
        publisher = mock(DomainEventPublisher.class);
        finder = mock(TaskFinder.class);

        doNothing().when(repository).save(any());
        doNothing().when(publisher).publish(anySet());
        when(finder.find(any())).thenReturn(task);
    }

    @Test
    public void should_delete_task() {

        TaskDeleter remover = new TaskDeleter(finder, repository, publisher);

        TaskId taskId = task.getTaskId();

        remover.delete(taskId);

        verify(task, times(1)).delete();
        verify(repository, times(1)).delete(taskId);
        verify(publisher, times(1)).publish(anySet());

    }
}
