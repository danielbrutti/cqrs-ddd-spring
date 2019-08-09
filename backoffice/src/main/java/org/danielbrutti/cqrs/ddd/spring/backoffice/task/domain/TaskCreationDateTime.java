package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.ImmutableDateTimeVO;

import java.time.LocalDateTime;

public final class TaskCreationDateTime extends ImmutableDateTimeVO {
    public TaskCreationDateTime(LocalDateTime localDateTime) {
        super(localDateTime);

        this.guardIsNotInFuture();
    }

    public static TaskCreationDateTime now() {
        return new TaskCreationDateTime(LocalDateTime.now());
    }
    private void guardIsNotInFuture() throws IllegalArgumentException {
        if (value.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Task Creation Date can not be in future");
        }
    }
}
