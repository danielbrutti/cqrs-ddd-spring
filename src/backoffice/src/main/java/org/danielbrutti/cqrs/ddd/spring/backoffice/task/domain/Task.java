package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        this.comments = new HashSet();
        this.state = new TaskState(TaskState.OPEN);
    }

    public static Task create(TaskId taskId, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDateTime creationDate) {
        Task task = new Task(taskId, type, title, priority, description, creationDate);

        task.record(
                new TaskCreatedDomainEvent(
                        taskId.value(),
                        task.toDataMap()
                )
        );

        return task;
    }

    public void update(Task task) {
        this.type = task.type;
        this.priority = task.priority;
        this.title = task.title;
        this.description = task.description;

        this.record(
                new TaskUpdatedDomainEvent(
                        taskId.value(),
                        toDataMap()
                )
        );
    }

    public void delete() {
        this.record(
                new TaskDeletedDomainEvent(
                        taskId.value(),
                        toDataMap()
                )
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

        Map<String, Object> commentMap = new HashMap<>();
        commentMap.put("commentId", comment.getCommentId());
        commentMap.put("commentContent", comment.getContent());

        Map<String, Object> map = toDataMap();
        map.put("comment", commentMap);

        this.record(
                new TaskCommentPublishedDomainEvent(
                        taskId.value(),
                        map
                )
        );
    }

    public void assign(DeveloperId developerId){
        this.state = new TaskState(TaskState.ASSIGNED);
        this.developerId = developerId;
        this.record(
                new TaskAssignedDomainEvent(
                        taskId.value(),
                        toDataMap()
                )
        );
    }

    public void unassign(){
        this.state = new TaskState(TaskState.OPEN);
        this.record(
                new TaskAssignedDomainEvent(
                        taskId.value(),
                        toDataMap()
                )
        );
        this.developerId = null;
    }

    public void close(){
        this.state = new TaskState(TaskState.CLOSED);
        this.record(
                new TaskAssignedDomainEvent(
                        taskId.value(),
                        toDataMap()
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

    /**
     * TODO Implement Aggregate to Event Data Serialization
     * I dont like to have a simple Map where key fields are hardcoded
     */
    private Map<String, Object> toDataMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type.value());
        map.put("title", title.value());
        map.put("priority", priority.value());
        map.put("description", description.value());
        map.put("state", state.value());
        map.put("developerId", developerId != null ? developerId.value() : null);
        map.put("creationDate", creationDate.value());
        return map;
    }
}
