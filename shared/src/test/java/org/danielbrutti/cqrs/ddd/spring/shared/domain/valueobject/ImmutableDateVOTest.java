package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import java.time.LocalDate;

import static org.junit.Assert.*;
import org.junit.Test;


public final class ImmutableDateVOTest {

    final ImmutableDateVO today = new ImmutableDateVO(LocalDate.now());
    final ImmutableDateVO yesterday = new ImmutableDateVO(LocalDate.now().minusDays(1));

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
