package com.example.springkafkastudy.service;

import com.example.springkafkastudy.exception.GlobalException;
import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.producer.TaskProducer;
import com.example.springkafkastudy.serde.serializer.TaskSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskService {

    private final TaskProducer taskProducer;
    private final TaskSerializer serializer;

    public TaskService(TaskProducer taskProducer, TaskSerializer serializer) {
        this.taskProducer = taskProducer;
        this.serializer = serializer;
    }

    public void sendTaskToKafka(TaskDto taskDto) {
        try {
            taskProducer.send(taskDto);
        } catch (Exception e) {
            log.error("Unable to send data to kafka: " + e);
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred");
        }
    }

    public void saveTask(TaskDto taskDto) {
        System.out.println(taskDto);
    }

}
