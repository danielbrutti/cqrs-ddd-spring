package org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence;

public final class CompositeSpecification implements Specification {
    private Specification leftSpecification;
    private Specification rightSpecification;
    private SpecificationOperator operator;

    public CompositeSpecification(Specification leftSpecification) {
        this.leftSpecification = leftSpecification;
    }

    public CompositeSpecification and(Specification value) {
        operator = SpecificationOperator.AND;
        rightSpecification = value;
        return this;
    }

    public CompositeSpecification or(Specification value) {
        operator = SpecificationOperator.OR;
        rightSpecification = value;
        return this;
    }

    public CompositeSpecification not() {
        operator = SpecificationOperator.NOT;
        return this;
    }

    @Override
    public String toString() {
        if (SpecificationOperator.NOT.equals(operator)) {
            return operator + " (" + leftSpecification + ")";
        }
        return "(" + leftSpecification + " " + operator + " " + rightSpecification + ")";
    }
}
