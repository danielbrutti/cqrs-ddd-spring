package com.jarilla.cqrs.ddd.spring.shared.domain.persistence;

public enum SpecificationOperator {
    EQUALS("="),
    NOT_EQUALS("!="),
    GREATHER_THAN(">"),
    LESS_THAN("<"),
    GREATHER_EQUAL_THAN(">="),
    LESS_EQUAL_THAN("<="),
    IN("IN"),
    NOT_IN("NOT IN"),
    AND("AND"),
    OR("OR"),
    NOT("NOT");

    private String value;

    private SpecificationOperator(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
