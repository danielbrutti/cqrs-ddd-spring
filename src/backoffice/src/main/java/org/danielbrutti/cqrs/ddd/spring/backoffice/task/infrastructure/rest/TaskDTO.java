package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure.rest;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public final class TaskDTO {

    @NotNull
    private String taskId;
    @NotNull
    private String title;
    @NotNull
    private String type;
    @NotNull
    private Integer priority;
    private String description;
    @NotNull
    private String state;
    private LocalDateTime creationDate;

    public TaskDTO(String taskId, String title, String type, Integer priority, String description, String state, LocalDateTime creationDate) {
        this.taskId = taskId;
        this.title = title;
        this.type = type;
        this.priority = priority;
        this.description = description;
        this.state = state;
        this.creationDate = creationDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
