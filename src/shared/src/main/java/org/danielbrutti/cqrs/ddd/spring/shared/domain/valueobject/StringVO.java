package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.util.Objects;

public class StringVO implements ValueObject<String> {

    protected String value;

    public StringVO(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringVO that = (StringVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}