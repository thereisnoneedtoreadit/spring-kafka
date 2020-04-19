package com.example.springkafkastudy.controller;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> create(@RequestBody Mono<TaskDto> task) {
        return task.publishOn(Schedulers.elastic())
                .map(taskService::create)
                .then();
    }

}
