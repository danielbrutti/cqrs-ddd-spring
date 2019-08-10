package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.Task;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskId;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public final class TaskInMemoryRepository implements TaskRepository {

    Map<TaskId, Task> map = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void save(Task task) {
        map.put(task.getTaskId(), task);
    }

    @Override
    public Optional<Task> find(TaskId taskId) {
        return Optional.ofNullable(map.get(taskId));
    }

    @Override
    public void delete(TaskId taskId) {
        map.remove(taskId);
    }
}