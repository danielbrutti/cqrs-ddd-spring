package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.Developer;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperName;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperCreator {

    private DeveloperRepository repository;
    private DomainEventPublisher publisher;

    public DeveloperCreator(DeveloperRepository repository, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    public void create(DeveloperId developerId, DeveloperName developerName) {
        Developer developer = Developer.create(developerId, developerName);

        this.repository.save(developer);

        this.publisher.publish(developer.pullDomainEvents());
    }
}
