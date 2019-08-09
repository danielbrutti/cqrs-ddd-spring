package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.valueobject.UuidVO;

import java.nio.charset.Charset;
import java.util.Random;

public final class TaskStub {

    public static Task random() {
        Task task = Task.create(
                randomTaskId(),
                randomType(),
                randomTitle(),
                randomPriority(),
                randomDescription(),
                randomCreationDate()
        );

        return task;
    }

    public static TaskCreationDateTime randomCreationDate() {
        return TaskCreationDateTime.now();
    }

    public static TaskDescription randomDescription() {
        return new TaskDescription(randomString(50));
    }

    public static TaskPriority randomPriority() {
        Random random = new Random();
        return new TaskPriority(random.nextInt(TaskPriority.MAX) + TaskPriority.MIN);
    }

    public static TaskTitle randomTitle() {
        return new TaskTitle(randomString(7));
    }

    private static String randomString(int lenght) {
        byte[] array = new byte[lenght]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    public static TaskType randomType() {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1:
                return new TaskType("Story");
            case 2:
                return new TaskType("Improvement");
            default:
                return new TaskType("Bug");
        }

    }

    public static TaskId randomTaskId() {
        return new TaskId(UuidVO.random().value());
    }
}
