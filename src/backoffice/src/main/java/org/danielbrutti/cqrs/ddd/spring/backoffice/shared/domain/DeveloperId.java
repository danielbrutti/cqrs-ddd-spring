package org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

public final class DeveloperId extends UuidVO {
    public DeveloperId(String value) {
        super(value);
    }
}
