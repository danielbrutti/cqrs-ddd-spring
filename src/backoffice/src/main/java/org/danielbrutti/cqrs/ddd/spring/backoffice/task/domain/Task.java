package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.util.HashSet;
import java.util.Set;

public final class Task extends AggregateRoot {

    private TaskId taskId;
    private TaskType type;
    private TaskTitle title;
    private TaskPriority priority;
    private TaskDescription description;
    private TaskState state;
    private TaskCreationDateTime creationDate;
    private DeveloperId developerId;

    private Set<Comment> comments;

    public Task(TaskId taskId, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDateTime creationDate) {
        this.taskId = taskId;
        this.type = type;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.comments = new HashSet<Comment>();
        this.state = new TaskState(TaskState.OPEN);
    }

    public static Task create(TaskId taskId, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDateTime creationDate) {
        Task task = new Task(taskId, type, title, priority, description, creationDate);

        task.record(
                new TaskCreatedDomainEvent(taskId.value())
        );

        return task;
    }

    public void update(Task task) {
        this.type = task.type;
        this.priority = task.priority;
        this.title = task.title;
        this.description = task.description;

        this.record(
                new TaskUpdatedDomainEvent(taskId.value())
        );
    }

    public void delete() {
        this.record(
                new TaskDeletedDomainEvent(taskId.value())
        );
    }

    public void publishComment(CommentContent content) {
        Comment comment = new Comment(
                this,
                new CommentId(UuidVO.random().value()),
                content,
                CommentDateTime.now()
        );
        this.comments.add(comment);

        this.record(
                new TaskCommentPublishedDomainEvent(
                        taskId.value(),
                        comment.getCommentId().value(),
                        comment.getContent().value()
                )
        );
    }

    public void assign(DeveloperId developerId) {
        this.state = new TaskState(TaskState.ASSIGNED);
        this.developerId = developerId;
        this.record(
                new TaskAssignedDomainEvent(
                        taskId.value(),
                        developerId != null ? developerId.value() : null
                )
        );
    }

    public void unassign() {
        this.state = new TaskState(TaskState.OPEN);
        this.record(
                new TaskUnassignedDomainEvent(
                        taskId.value(),
                        developerId != null ? developerId.value() : null
                )
        );
        this.developerId = null;
    }

    public void close() {
        this.state = new TaskState(TaskState.CLOSED);
        this.record(
                new TaskClosedDomainEvent(
                        taskId.value(),
                        developerId != null ? developerId.value() : null
                )
        );
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public TaskType getType() {
        return type;
    }

    public TaskTitle getTitle() {
        return title;
    }

    public TaskDescription getDescription() {
        return description;
    }

    public Set<Comment> getComments() {
        return comments;
    }

}
