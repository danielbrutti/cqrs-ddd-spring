package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

public final class TaskNotFound extends RuntimeException {

    private TaskId id;

    public TaskNotFound(TaskId id) {
        this.id = id;
    }
}
