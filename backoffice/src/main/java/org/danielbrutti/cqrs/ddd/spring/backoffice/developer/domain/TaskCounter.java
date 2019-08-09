package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.IntegerVO;

public final class TaskCounter extends IntegerVO {
    public TaskCounter(Integer value) {
        super(value);
    }

    public void increase() {
        value++;
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }
}
