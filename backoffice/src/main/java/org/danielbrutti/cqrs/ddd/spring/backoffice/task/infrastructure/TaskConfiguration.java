package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.application.TaskCreator;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.danielbrutti.cqrs.ddd.spring.shared.infrastructure.bus.event.GuavaDomainEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfiguration {

    @Autowired
    private TaskInMemoryRepository taskInMemoryRepository;

    @Bean
    public TaskCreator taskCreator() {
        return new TaskCreator(taskInMemoryRepository, domainEventPublisher());
    }

    @Bean
    public DomainEventPublisher domainEventPublisher() {
        return new GuavaDomainEventBus();
    }

}
