package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

public final class CommentId extends UuidVO {

    public CommentId(String value) {
        super(value);
    }
}
