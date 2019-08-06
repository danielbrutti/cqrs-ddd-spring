package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;

public final class DeveloperFinder {

    private DeveloperRepository repository;

    public DeveloperFinder(DeveloperRepository repository) {
        this.repository = repository;
    }

    public Developer find(DeveloperId id) {
        Developer developer = this.repository.find(id);

        this.guardDeveloperExists(developer);

        return developer;
    }

    private void guardDeveloperExists(Developer developer) {
        if (null == developer) throw new DeveloperNotFound(developer.getDeveloperId());
    }
}
