package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDate;
import java.util.Objects;

public class ImmutableDateVO implements ValueObject<LocalDate> {

    protected LocalDate value;

    public ImmutableDateVO(LocalDate localDate){
        this.value = localDate;
    }

    public boolean isBefore(ImmutableDateVO other) {
        return this.value.isBefore(other.value);
    }

    public boolean isAfter(ImmutableDateVO other) {
        return this.value.isAfter(other.value);
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableDateVO that = (ImmutableDateVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}