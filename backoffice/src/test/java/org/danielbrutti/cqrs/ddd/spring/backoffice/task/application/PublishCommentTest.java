package org.danielbrutti.cqrs.ddd.spring.backoffice.task.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public final class PublishCommentTest {

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
    public void should_create_comment() {

        TaskCommentPublisher commentPublisher = new TaskCommentPublisher(finder, repository, publisher);

        CommentContent content = new CommentContent("A new comment for my task");

        commentPublisher.publish(task.getTaskId(), content);

        verify(repository, times(1)).save(any());
        verify(publisher, times(1)).publish(anySet());
        verify(task, times(1)).publishComment(content);
    }
}
