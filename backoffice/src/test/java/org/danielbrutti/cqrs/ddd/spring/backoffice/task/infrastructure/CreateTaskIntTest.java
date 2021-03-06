package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.application.TaskCreator;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEventPublisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public final class CreateTaskIntTest {

    @Autowired
    private TaskCreator creator;

    @Autowired
    private TaskInMemoryRepository repository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    @Before
    public void setUp() {
        repository = spy(repository);
        domainEventPublisher = spy(domainEventPublisher);
    }

    @Test
    public void should_create_task() {

        TaskId id = TaskStub.randomTaskId();
        TaskType type = TaskStub.randomType();
        TaskTitle title = TaskStub.randomTitle();
        TaskPriority priority = TaskStub.randomPriority();
        TaskDescription description = TaskStub.randomDescription();
        TaskCreationDateTime creationDate = TaskStub.randomCreationDate();

        creator.create(id, type, title, priority, description, creationDate);

        Optional<Task> task = repository.find(id);
        assertTrue(task.isPresent());
        assertNotNull(task.get());

    }
}
