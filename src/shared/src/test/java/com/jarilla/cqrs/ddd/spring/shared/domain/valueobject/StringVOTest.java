package com.jarilla.cqrs.ddd.spring.shared.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringVOTest {

    @Test
    void equal_than() {
        final StringVO hello = new StringVO("Hello");
        final StringVO world = new StringVO("World");
        assertTrue(hello.equals(hello));
        assertFalse(hello.equals(world));
    }

}
