package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

import static org.junit.Assert.*;
import org.junit.Test;

public final class StringVOTest {

    @Test
    public void equal_than() {
        final StringVO hello = new StringVO("Hello");
        final StringVO world = new StringVO("World");
        assertTrue(hello.equals(hello));
        assertFalse(hello.equals(world));
    }

}
