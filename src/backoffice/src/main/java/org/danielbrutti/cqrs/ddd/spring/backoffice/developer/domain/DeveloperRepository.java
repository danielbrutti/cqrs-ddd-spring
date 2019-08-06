package org.danielbrutti.cqrs.ddd.spring.backoffice.developer.domain;

import org.danielbrutti.cqrs.ddd.spring.backoffice.shared.domain.DeveloperId;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence.DomainRepository;

public interface DeveloperRepository extends DomainRepository<Developer, DeveloperId> {
}
