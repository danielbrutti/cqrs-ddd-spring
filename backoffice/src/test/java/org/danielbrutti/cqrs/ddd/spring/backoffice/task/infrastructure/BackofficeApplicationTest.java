package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.application.TaskCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public final class BackofficeApplicationTest {

    @Autowired
    private TaskCreator taskCreator;

    @Test
    public void context_should_start() {
        assertNotNull(taskCreator);
    }
}
