package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public final class TaskTitle extends StringVO {

    public TaskTitle(String value) {
        super(value);
        this.titleCanNotBeEmpty();
    }

    public void titleCanNotBeEmpty() {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("Task title can not be empty");
    }

}
