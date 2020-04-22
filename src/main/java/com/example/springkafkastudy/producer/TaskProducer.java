package com.example.springkafkastudy.producer;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.example.springkafkastudy.serde.serializer.TaskSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskProducer extends Producer{

    private final TaskSerializer serializer;

    @Value("${kafka.tasks.topic}")
    private String taskTopic;

    protected TaskProducer(KafkaTemplate<String, byte[]> kafkaTemplate, TaskSerializer serializer) {
        super(kafkaTemplate);
        this.serializer = serializer;
    }

    public void send(TaskDto taskDto) {
        super.send(taskTopic, serializer.serialize(taskDto));
    }

}
