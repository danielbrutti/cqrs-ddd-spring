package com.jarilla.cqrs.ddd.spring.shared.domain.persistence;

public final class CompositeSpecification implements Specification {
    private Specification leftSpecification;
    private Specification rightSpecification;
    private SpecificationOperator operator;

    public CompositeSpecification(Specification leftSpecification) {
        this.leftSpecification = leftSpecification;
    }

    public void and(Specification value) {
        operator = SpecificationOperator.AND;
        rightSpecification = value;
    }

    public void or(Specification value) {
        operator = SpecificationOperator.OR;
        rightSpecification = value;
    }

    public void not() {
        operator = SpecificationOperator.NOT;
    }

    @Override
    public String toString() {
        if (SpecificationOperator.NOT.equals(operator)) {
            return operator + " (" + leftSpecification + ")";
        }
        return "(" + leftSpecification + " " + operator + " " + rightSpecification + ")";
    }
}
