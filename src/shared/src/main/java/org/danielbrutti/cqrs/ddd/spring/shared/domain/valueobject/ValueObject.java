package org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject;

public interface ValueObject<DataType> {

    DataType value();

}
