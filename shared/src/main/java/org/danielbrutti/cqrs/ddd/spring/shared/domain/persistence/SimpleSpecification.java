package org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.ValueObject;

import java.util.Set;
import java.util.stream.Collectors;

public final class SimpleSpecification implements Specification {

    private String attribute;
    private ValueObject value;
    private Set<ValueObject> values;
    private SpecificationOperator operator;

    public SimpleSpecification(String attribute) {
        this.attribute = attribute;
    }

    public void equalsTo(ValueObject value) {
        operator = SpecificationOperator.EQUALS;
        this.value = value;
    }

    public void notEquals(ValueObject value) {
        operator = SpecificationOperator.NOT_EQUALS;
        this.value = value;
    }

    public void greatherThan(ValueObject value) {
        operator = SpecificationOperator.GREATHER_THAN;
        this.value = value;
    }

    public void greatherEqualsThan(ValueObject value) {
        operator = SpecificationOperator.GREATHER_EQUAL_THAN;
        this.value = value;
    }

    public void lessThan(ValueObject value) {
        operator = SpecificationOperator.LESS_THAN;
        this.value = value;
    }

    public void lessEqualThan(ValueObject value) {
        operator = SpecificationOperator.LESS_EQUAL_THAN;
        this.value = value;
    }

    public void in(Set<ValueObject> values) {
        operator = SpecificationOperator.IN;
        this.values = values;
    }

    public void notIn(Set<ValueObject> values) {
        operator = SpecificationOperator.NOT_IN;
        this.values = values;
    }

    @Override
    public String toString() {
        if (SpecificationOperator.IN.equals(operator) || SpecificationOperator.NOT_IN.equals(operator)) {
            return attribute + " "
                    + operator.value()
                    + " ("
                    + values.stream()
                    .map(ValueObject::value)
                    .map(Object::toString)
                    .sorted()
                    .collect(Collectors.joining(", "))
                    + ")";
        }
        return attribute + " " + operator.value() + " " + value.value();
    }
}