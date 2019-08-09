package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.StringVO;

public final class DeveloperName extends StringVO {
    public DeveloperName(String value) {
        super(value);
        this.guardNameIsNotEmpty();
    }

    private void guardNameIsNotEmpty() throws IllegalArgumentException {
        if (null == value || value.isEmpty()) {
            throw new IllegalArgumentException("Developer name can not be empty");
        }
    }
}
