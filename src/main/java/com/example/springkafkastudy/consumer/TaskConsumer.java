package com.example.springkafkastudy.consumer;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.serde.deserializer.TaskDeserializer;
import com.example.springkafkastudy.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskConsumer {

    private final TaskDeserializer deserializer;
    private final TaskService taskService;

    public TaskConsumer(TaskDeserializer deserializer, TaskService taskService) {
        this.deserializer = deserializer;
        this.taskService = taskService;
    }

    @KafkaListener(topics = "${kafka.tasks.topic}", groupId = "${kafka.groupid}")
    public void listen(byte[] task) {
        TaskDto taskDto = deserializer.deserialize(task);
        log.info("Received Message: " + taskDto);
        taskService.saveTask(taskDto);
    }

}
