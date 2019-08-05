package com.jarilla.cqrs.ddd.spring.shared.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class UuidVO implements ValueObject<String> {

    private String value;

    public UuidVO(String value) {
        this.guardValidUuid(value);
        this.value = value;
    }

    public static UuidVO random() {
        UUID uuid = UUID.randomUUID();
        return new UuidVO(uuid.toString());
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UuidVO that = (UuidVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private boolean guardValidUuid(String id) {
        return UUID.fromString(id) != null;
    }
}