package org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.IntegerVO;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;
import static org.junit.Assert.*;
import org.junit.Test;


import java.util.Set;

public final class SpecificationTest {

    @Test
    public void equals_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());
    }

    @Test
    public void not_equals_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.notEquals(new IntegerVO(100));

        assertEquals("variable != 100", specification.toString());
    }

    @Test
    public void greather_equals_than_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.greatherEqualsThan(new IntegerVO(100));

        assertEquals("variable >= 100", specification.toString());
    }

    @Test
    public void greather_than_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.greatherThan(new IntegerVO(100));

        assertEquals("variable > 100", specification.toString());
    }

    @Test
    public void less_equals_than_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.lessEqualThan(new IntegerVO(100));

        assertEquals("variable <= 100", specification.toString());
    }

    @Test
    public void less_than_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.lessThan(new IntegerVO(100));

        assertEquals("variable < 100", specification.toString());
    }

    @Test
    public void in_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.in(Set.of(new IntegerVO(100), new IntegerVO(200)));

        assertEquals("variable IN (100, 200)", specification.toString());
    }

    @Test
    public void not_in_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.notIn(Set.of(new IntegerVO(100), new IntegerVO(200)));

        assertEquals("variable NOT IN (100, 200)", specification.toString());
    }

    @Test
    public void and_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());

        SimpleSpecification specification2 = new SimpleSpecification("other");
        specification2.equalsTo(new StringVO("Hello"));

        assertEquals("other = Hello", specification2.toString());

        CompositeSpecification andSpecification = new CompositeSpecification(specification)
                .and(specification2);

        assertEquals("(variable = 100 AND other = Hello)", andSpecification.toString());
    }

    @Test
    public void or_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());

        SimpleSpecification specification2 = new SimpleSpecification("other");
        specification2.equalsTo(new StringVO("Hello"));

        assertEquals("other = Hello", specification2.toString());

        CompositeSpecification andSpecification = new CompositeSpecification(specification)
                .or(specification2);

        assertEquals("(variable = 100 OR other = Hello)", andSpecification.toString());
    }

    @Test
    public void not_specification() {
        SimpleSpecification specification = new SimpleSpecification("variable");
        specification.equalsTo(new IntegerVO(100));

        assertEquals("variable = 100", specification.toString());

        CompositeSpecification notSpecification = new CompositeSpecification(specification).not();

        assertEquals("NOT (variable = 100)", notSpecification.toString());
    }
}
