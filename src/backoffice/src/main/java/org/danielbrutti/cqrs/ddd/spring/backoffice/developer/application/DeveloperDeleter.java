package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.application;

import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.Developer;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperFinder;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.DeveloperRepository;
import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;

public final class DeveloperDeleter {

    private DeveloperRepository repository;
    private DeveloperFinder finder;
    private DomainEventPublisher publisher;

    public DeveloperDeleter(DeveloperFinder finder, DeveloperRepository repository, DomainEventPublisher publisher) {
        this.finder = finder;
        this.repository = repository;
        this.publisher = publisher;
    }


    public void delete(DeveloperId id) {
        Developer task = finder.find(id);
        task.delete();

        this.repository.delete(id);

        this.publisher.publish(task.pullDomainEvents());
    }
}
