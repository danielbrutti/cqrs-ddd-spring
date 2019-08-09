package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.application.TaskCreator;
import org.danielbrutti.cqrs.ddd.spring.shared.infrastructure.bus.event.GuavaDomainEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TaskConfiguration {

//    @Bean
    public TaskCreator taskCreator() {
        return new TaskCreator(new TaskInMemoryRepository(), new GuavaDomainEventBus());
    }
}
