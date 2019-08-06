package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public class TaskState extends StringVO {

    public static final String OPEN = "OPEN";
    public static final String ASSIGNED = "ASSIGNED";
    public static final String CLOSED = "CLOSED";

    public TaskState(String value) {
        super(value);
    }

}
