package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskStub;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public final class TaskAssignerTest {

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
    public void should_assign_task() {

        TaskAssigner assigner = new TaskAssigner(finder, repository, publisher);

        DeveloperId developerId = new DeveloperId(UuidVO.random().value());
        assigner.assign(task.getTaskId(), developerId);

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());
        verify(task, times(1)).assign(developerId);
    }
}
