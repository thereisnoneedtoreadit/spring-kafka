package com.example.springkafkastudy.service;

import com.example.springkafkastudy.exception.GlobalException;
import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.model.entity.Task;
import com.example.springkafkastudy.producer.TaskProducer;
import com.example.springkafkastudy.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskService {

    private final TaskProducer taskProducer;
    private final TaskRepository taskRepository;

    public TaskService(TaskProducer taskProducer, TaskRepository taskRepository) {
        this.taskProducer = taskProducer;
        this.taskRepository = taskRepository;
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
        Task task = taskDto.asEntity();
        taskRepository.save(task);
        log.info("Saved: {}", task);
    }

}
