package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskStub;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public final class TaskUnassignerTest {

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
    public void should_unassign_task() {

        TaskUnassigner unassigner = new TaskUnassigner(finder, repository, publisher);

        unassigner.unassign(task.getTaskId());

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());
        verify(task, times(1)).unassign();
    }
}
