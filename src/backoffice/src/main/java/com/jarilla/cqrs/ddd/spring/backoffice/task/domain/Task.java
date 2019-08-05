package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;

import java.util.HashMap;
import java.util.Map;

public final class Task extends AggregateRoot {

    private TaskId taskId;
    private TaskType type;
    private TaskTitle title;
    private TaskPriority priority;
    private TaskDescription description;
    private TaskCreationDate creationDate;

    public Task(TaskId taskId, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDate creationDate) {
        this.taskId = taskId;
        this.type = type;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public static Task create(TaskId taskId, TaskType type, TaskTitle title, TaskPriority priority, TaskDescription description, TaskCreationDate creationDate) {
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
        map.put("creationDate", creationDate.value());
        return map;
    }
}
