package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence.DomainRepository;

public interface TaskRepository extends DomainRepository<Task, TaskId> {
}
