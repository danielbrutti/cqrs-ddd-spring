package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

import java.util.Optional;

public final class TaskFinder {

    private TaskRepository taskRepository;

    public TaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task find(TaskId id) {
        Optional<Task> task = this.taskRepository.find(id);

        this.guardTaskExists(task, id);

        return task.get();
    }

    private void guardTaskExists(Optional<Task> task, TaskId taskId) {
        if (task.isPresent() == false) throw new TaskNotFound(taskId);
    }
}
