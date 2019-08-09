package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public final class CommentContent extends StringVO {

    public CommentContent(String value) {
        super(value);
    }

}
