package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskStub;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public final class TaskCloserTest {

    private TaskRepository repository;
    private TaskFinder finder;
    private DomainEventPublisher publisher;

    private static Task task;

    @BeforeEach
    void setUp() {
        task = spy(TaskStub.random());

        repository = mock(TaskRepository.class);
        publisher = mock(DomainEventPublisher.class);
        finder = mock(TaskFinder.class);

        doNothing().when(repository).save(any());
        doNothing().when(publisher).publish(anySet());
        when(finder.find(any())).thenReturn(task);

    }

    @Test
    void should_cloud_task() {

        TaskCloser closer = new TaskCloser(finder, repository, publisher);

        closer.close(task.getTaskId());

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());
        verify(task, times(1)).close();
    }
}
