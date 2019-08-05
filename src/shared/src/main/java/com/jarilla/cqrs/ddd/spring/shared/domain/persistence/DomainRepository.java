package com.jarilla.cqrs.ddd.spring.shared.domain.persistence;

import com.jarilla.cqrs.ddd.spring.shared.domain.aggregate.AggregateRoot;
import com.jarilla.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

public interface DomainRepository<DomainEntity extends AggregateRoot, Id extends UuidVO> {

    void save(DomainEntity entity);

    DomainEntity find(Id id);

    void delete(Id id);
}
