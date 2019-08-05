package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.InmutableDateTimeVO;

import java.time.LocalDateTime;

public final class TaskCreationDate extends InmutableDateTimeVO {
    public TaskCreationDate(LocalDateTime localDateTime) {
        super(localDateTime);

        this.guardIsNotInFuture();
    }

    private void guardIsNotInFuture() throws IllegalArgumentException {
        if (value.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Creation date can not be in future");
        }
    }
}
