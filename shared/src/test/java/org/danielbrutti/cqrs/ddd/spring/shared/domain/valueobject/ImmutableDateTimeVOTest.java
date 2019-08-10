package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import org.junit.Test;


public final class ImmutableDateTimeVOTest {

    final ImmutableDateTimeVO today = new ImmutableDateTimeVO(LocalDateTime.now());
    final ImmutableDateTimeVO yesterday = new ImmutableDateTimeVO(LocalDateTime.now().minusMinutes(10));

    @Test
    public void greather_than() {
        assertTrue(today.isAfter(yesterday));
        assertFalse(yesterday.isAfter(today));
    }

    @Test
    public void less_than() {
        assertTrue(yesterday.isBefore(today));
        assertFalse(yesterday.isAfter(today));
    }
}
