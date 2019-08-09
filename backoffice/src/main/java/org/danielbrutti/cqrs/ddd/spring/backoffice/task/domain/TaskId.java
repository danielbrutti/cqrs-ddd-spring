package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

public final class TaskId extends UuidVO {

    public TaskId(String value) {
        super(value);
    }
}
