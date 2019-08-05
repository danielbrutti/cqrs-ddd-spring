package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public class TaskType extends StringVO {

    public TaskType(String value) {
        super(value);
    }
}
