package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event.DeveloperCreatedDomainEvent;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event.DeveloperDeletedDomainEvent;
import org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain.event.DeveloperUpdatedDomainEvent;
import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;

import java.util.HashMap;
import java.util.Map;

public final class Developer extends AggregateRoot {

    private DeveloperId developerId;
    private DeveloperName name;
    private TaskCounter assignedTaskCounter;

    public Developer(DeveloperId developerId, DeveloperName name) {
        this.developerId = developerId;
        this.name = name;
        this.assignedTaskCounter = new TaskCounter(0);
    }

    private static Developer create(DeveloperId developerId, DeveloperName name) {
        Developer developer = new Developer(developerId, name);

        developer.record(
                new DeveloperCreatedDomainEvent(
                        developerId.value(),
                        developer.toDataMap()
                )
        );
        return developer;
    }

    public void update(Developer developer) {
        this.name = developer.name;

        this.record(
                new DeveloperUpdatedDomainEvent(
                        developerId.value(),
                        toDataMap()
                )
        );
    }

    public void delete() {
        this.record(
                new DeveloperDeletedDomainEvent(
                        developerId.value(),
                        toDataMap()
                )
        );
    }

    public void taskAssigned() {
        this.assignedTaskCounter.increase();
    }

    public void taskUnassigned() {
        this.assignedTaskCounter.decrease();
    }

    public DeveloperId getDeveloperId() {
        return developerId;
    }

    public DeveloperName getName() {
        return name;
    }

    /**
     * TODO Implement Aggregate to Event Data Serialization
     * I dont like to have a simple Map where key fields are hardcoded
     */
    private Map<String, Object> toDataMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.value());
        return map;
    }
}
