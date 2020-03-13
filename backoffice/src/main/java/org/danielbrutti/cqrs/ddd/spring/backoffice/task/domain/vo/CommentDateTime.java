package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.ImmutableDateTimeVO;

import java.time.LocalDateTime;

public final class CommentDateTime extends ImmutableDateTimeVO {
    public CommentDateTime(LocalDateTime localDateTime) {
        super(localDateTime);

        this.guardIsNotInFuture();
    }

    public static CommentDateTime now() {
        return new CommentDateTime(LocalDateTime.now());
    }

    private void guardIsNotInFuture() throws IllegalArgumentException {
        if (value.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Task History Date can not be in future");
        }
    }
}
