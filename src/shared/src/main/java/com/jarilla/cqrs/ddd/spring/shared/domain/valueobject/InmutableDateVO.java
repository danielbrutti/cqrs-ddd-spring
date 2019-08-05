package com.jarilla.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDate;
import java.util.Objects;

public class InmutableDateVO implements ValueObject<LocalDate> {

    protected LocalDate value;

    public InmutableDateVO(LocalDate localDate){
        this.value = localDate;
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InmutableDateVO that = (InmutableDateVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}