package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.util.UUID;

import static org.junit.Assert.*;
import org.junit.Test;

public final class UuidVOTest {

    @Test
    public void unique_id() {
        final UuidVO uuidVO = UuidVO.random();
        final UuidVO uuidVO2 = UuidVO.random();

        assertFalse(uuidVO.equals(uuidVO2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_id() {
        final String badId = "some-bad-id";
        new UuidVO(badId);
    }

    @Test
    public void valid_id() {
        final String badId = UUID.randomUUID().toString();
        UuidVO uuidVO = new UuidVO(badId);
    }

}
