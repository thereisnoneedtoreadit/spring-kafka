package com.example.springkafkastudy.service;

import com.example.springkafkastudy.exception.GlobalException;
import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.producer.TaskProducer;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskProducer taskProducer;

    public TaskService(TaskProducer taskProducer) {
        this.taskProducer = taskProducer;
    }

    @SneakyThrows
    public void createTask(TaskDto task) {
        try {
            taskProducer.send(task);
        } catch (Exception e) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred");
        }
    }

}
