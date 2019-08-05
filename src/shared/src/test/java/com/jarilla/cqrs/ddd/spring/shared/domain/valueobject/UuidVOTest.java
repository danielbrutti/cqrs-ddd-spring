package com.jarilla.cqrs.ddd.spring.shared.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public final class UuidVOTest {

    @Test
    void unique_id() {
        final UuidVO uuidVO = UuidVO.random();
        final UuidVO uuidVO2 = UuidVO.random();

        assertFalse(uuidVO.equals(uuidVO2));
    }

    @Test()
    void invalid_id() {
        assertThrows(IllegalArgumentException.class, () -> {
            final String badId = "some-bad-id";
            new UuidVO(badId);
        });
    }

    @Test
    void valid_id() {
        final String badId = UUID.randomUUID().toString();
        UuidVO uuidVO = new UuidVO(badId);
    }

}
