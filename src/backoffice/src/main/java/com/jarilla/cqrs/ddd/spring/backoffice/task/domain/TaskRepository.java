package com.jarilla.cqrs.ddd.spring.backoffice.task.domain;

import com.jarilla.cqrs.ddd.spring.shared.domain.persistence.DomainRepository;

public interface TaskRepository extends DomainRepository<Task, TaskId> {
}
