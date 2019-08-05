package com.jarilla.cqrs.ddd.spring.shared.domain.persistence;

import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.IntegerVO;
import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.StringVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class SpecificationTest {

    @Test
    void testCreateSimpleSpecification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());
    }

    @Test
    void testCreateAndSpecification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());

        SimpleSpecification specification2 = new SimpleSpecification("other");
        specification2.equalsTo(new StringVO("Hello"));

        assertEquals("other = Hello", specification2.toString());

        CompositeSpecification andSpecification = new CompositeSpecification(specification);
        andSpecification.and(specification2);

        assertEquals("(variable = 100 AND other = Hello)", andSpecification.toString());
    }
}
