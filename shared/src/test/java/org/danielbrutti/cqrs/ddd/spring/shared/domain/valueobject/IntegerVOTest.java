package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import static org.junit.Assert.*;
import org.junit.Test;


public final class IntegerVOTest {

    final IntegerVO value20 = new IntegerVO(20);
    final IntegerVO value10 = new IntegerVO(10);

    @Test
    public void greather_than() {
        assertTrue(value20.isGreatherThan(value10));
        assertFalse(value10.isGreatherThan(value20));
        assertFalse(value10.isGreatherThan(value10));
    }

    @Test
    public void less_than() {
        assertTrue(value10.isLessThan(value20));
        assertFalse(value20.isLessThan(value10));
        assertFalse(value20.isLessThan(value20));
    }

    @Test
    public void greather_equal_than() {
        assertTrue(value20.isGreatherEqualThan(value10));
        assertTrue(value20.isGreatherEqualThan(value20));
        assertFalse(value10.isGreatherEqualThan(value20));
    }

    @Test
    public void less_equal_than() {
        assertTrue(value10.isLessEqualThan(value20));
        assertTrue(value10.isLessEqualThan(value10));
        assertFalse(value20.isLessEqualThan(value10));
    }

    @Test
    public void equal_than() {
        assertTrue(value20.isEqualThan(value20));
        assertFalse(value20.isEqualThan(value10));

        assertTrue(value20.equals(value20));
        assertFalse(value10.equals(value20));
    }

}
