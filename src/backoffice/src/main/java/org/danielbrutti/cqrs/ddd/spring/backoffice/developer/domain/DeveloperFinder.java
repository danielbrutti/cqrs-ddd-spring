package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;

import java.util.Optional;

public final class DeveloperFinder {

    private DeveloperRepository repository;

    public DeveloperFinder(DeveloperRepository repository) {
        this.repository = repository;
    }

    public Developer find(DeveloperId id) {
        Optional<Developer> developer = this.repository.find(id);

        this.guardDeveloperExists(developer, id);

        return developer.get();
    }

    private void guardDeveloperExists(Optional<Developer> developer, DeveloperId developerId) {
        if (developer.isPresent() == false) throw new DeveloperNotFound(developerId);
    }
}
