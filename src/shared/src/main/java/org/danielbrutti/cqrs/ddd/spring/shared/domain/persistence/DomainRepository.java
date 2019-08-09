package org.danielbrutti.cqrs.ddd.spring.shared.domain.persistence;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.util.Optional;

public interface DomainRepository<DomainEntity extends AggregateRoot, Id extends UuidVO> {

    void save(DomainEntity entity);

    Optional<DomainEntity> find(Id id);

    void delete(Id id);
}
