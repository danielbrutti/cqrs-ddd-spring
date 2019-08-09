package org.danielbrutti.cqrs.ddd.spring.backoffice.task.infrastructure.rest;

import org.danielbrutti.cqrs.ddd.spring.backoffice.task.application.TaskCreator;
import org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public final class TaskPostController {

    private TaskCreator creator;

    public TaskPostController(TaskCreator creator) {
        this.creator = creator;
    }

    @PostMapping(path = "/task")
    public ResponseEntity create(@RequestBody TaskDTO taskDTO) {

        // TODO replace this with a CQRS Command
        TaskId id = new TaskId(taskDTO.getTaskId());
        TaskType type = new TaskType(taskDTO.getType());
        TaskTitle title = new TaskTitle(taskDTO.getTitle());
        TaskPriority priority = new TaskPriority(taskDTO.getPriority());
        TaskDescription description = new TaskDescription(taskDTO.getDescription());

        TaskCreationDateTime creationDate = TaskCreationDateTime.now();

        this.creator.create(id, type, title, priority, description, creationDate);

        return ResponseEntity.ok().build();
    }
}
