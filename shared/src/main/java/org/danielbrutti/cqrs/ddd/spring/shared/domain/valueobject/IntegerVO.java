package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.util.Objects;

public class IntegerVO implements ValueObject<Integer> {

    protected Integer value;

    public IntegerVO(Integer value){
        this.value = value;
    }

    public boolean isGreatherThan(IntegerVO other) {
        return this.value > other.value;
    }

    public boolean isLessThan(IntegerVO other) {
        return this.value < other.value;
    }

    public boolean isGreatherEqualThan(IntegerVO other) {
        return this.value >= other.value;
    }

    public boolean isLessEqualThan(IntegerVO other) {
        return this.value <= other.value;
    }

    public boolean isEqualThan(IntegerVO other) {
        return this.value == other.value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerVO that = (IntegerVO) o;
        return this.isEqualThan(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}