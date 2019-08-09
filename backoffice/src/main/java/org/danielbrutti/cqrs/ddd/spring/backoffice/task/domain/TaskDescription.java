package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public final class TaskDescription extends StringVO {

    public TaskDescription(String value) {
        super(value);
    }

}
