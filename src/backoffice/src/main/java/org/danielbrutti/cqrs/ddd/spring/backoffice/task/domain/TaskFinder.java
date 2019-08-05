package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

public final class TaskFinder {

    private TaskRepository taskRepository;

    public TaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task find(TaskId id) {
        Task task = this.taskRepository.find(id);

        this.guardTaskExists(task);

        return task;
    }

    private void guardTaskExists(Task task) {
        if (null == task) throw new TaskNotFound(task.getTaskId());
    }
}
