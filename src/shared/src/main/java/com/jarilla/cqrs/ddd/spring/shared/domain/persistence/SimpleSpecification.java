package com.jarilla.cqrs.ddd.spring.shared.domain.persistence;

import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.ValueObject;

public final class SimpleSpecification implements Specification {

    private String attribute;
    private ValueObject value;
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

    public void in(ValueObject value) {
        operator = SpecificationOperator.IN;
        this.value = value;
    }

    public void notIn(ValueObject value) {
        operator = SpecificationOperator.NOT_IN;
        this.value = value;
    }

    @Override
    public String toString() {
        if (SpecificationOperator.IN.equals(operator) || SpecificationOperator.NOT_IN.equals(operator)){
            return attribute + " " + operator.value() + " (" + value.value() + ")";
        }
        return attribute + " " +  operator.value() + " " + value.value();
    }
}