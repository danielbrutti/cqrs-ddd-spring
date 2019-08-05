package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.IntegerVO;

public final class TaskPriority extends IntegerVO {

    private static final Integer MIN = 1;
    private static final Integer MAX = 3;

    public TaskPriority(Integer value) {
        super(value);
        guardValidPriority();
    }

    public void guardValidPriority() {
        if (value < MIN || value > MAX)
            throw new IllegalArgumentException(String.format("Priority must be between %d and %d", MIN, MAX));
    }

    public void increasePriority() {
        if (value < MAX) value++;
    }

    public void decreasePriority() {
        if (value > MIN) value--;
    }

    public void maximumPriority() {
        value = MAX;
    }

    public void minimumPriority() {
        value = MIN;
    }
}
