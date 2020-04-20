package com.example.springkafkastudy.controller;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<TaskDto> createTask(@RequestBody Mono<TaskDto> task) {
        return task.map(taskDto -> {
            taskService.createTask(taskDto);
            return taskDto;
        });
    }

}
