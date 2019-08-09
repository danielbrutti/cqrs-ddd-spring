package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDateTime;
import java.util.Objects;

public class ImmutableDateTimeVO implements ValueObject<LocalDateTime> {

    protected LocalDateTime value;

    public ImmutableDateTimeVO(LocalDateTime localDateTime){
        this.value = localDateTime;
    }

    @Override
    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableDateTimeVO that = (ImmutableDateTimeVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}