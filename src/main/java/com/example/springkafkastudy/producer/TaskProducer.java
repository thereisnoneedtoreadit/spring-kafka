package com.example.springkafkastudy.producer;

import com.example.springkafkastudy.model.dto.TaskDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class TaskProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.tasks.topic}")
    private String taskTopic;

    public TaskProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void send(TaskDto task) {

        ListenableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send(taskTopic, task);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Sent message=[" + task +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=["
                        + task + "] due to : " + ex.getMessage());
            }
        });
    }

}
