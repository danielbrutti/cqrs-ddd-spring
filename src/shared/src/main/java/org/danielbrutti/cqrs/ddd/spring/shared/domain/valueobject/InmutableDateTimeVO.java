package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDateTime;
import java.util.Objects;

public class InmutableDateTimeVO implements ValueObject<LocalDateTime> {

    protected LocalDateTime value;

    public InmutableDateTimeVO(LocalDateTime localDateTime){
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
        InmutableDateTimeVO that = (InmutableDateTimeVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}