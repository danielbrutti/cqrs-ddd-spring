package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.Developer;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperRepository;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperUpdater {

    private DeveloperRepository repository;
    private DeveloperFinder finder;
    private DomainEventPublisher publisher;

    public DeveloperUpdater(DeveloperFinder finder, DeveloperRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }


    public void update(Developer updated) {
        Developer existent = finder.find(updated.getDeveloperId());

        existent.update(updated);

        this.repository.save(existent);

        this.publisher.publish(existent.pullDomainEvents());
    }
}
