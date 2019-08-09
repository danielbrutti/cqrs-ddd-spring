package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.Developer;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperTaskAssigner {

    private DeveloperRepository repository;
    private DeveloperFinder finder;
    private DomainEventPublisher publisher;

    public DeveloperTaskAssigner(DeveloperFinder finder, DeveloperRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }


    public void assign(DeveloperId developerId) {
        Developer developer = finder.find(developerId);

        developer.taskAssigned();

        this.repository.save(developer);

        this.publisher.publish(developer.pullDomainEvents());
    }
}
