package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;

public final class DeveloperNotFound extends RuntimeException {

    private DeveloperId id;

    public DeveloperNotFound(DeveloperId id) {
        this.id = id;
    }
}
