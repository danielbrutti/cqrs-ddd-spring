package com.jarilla.cqrs.ddd.spring.shared.domain.valueobject;

public interface ValueObject<DataType> {

    DataType value();

}
