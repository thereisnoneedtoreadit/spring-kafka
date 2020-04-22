package com.example.springkafkastudy.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public abstract class Producer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    protected Producer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, byte[] obj) {

        ListenableFuture<SendResult<String, byte[]>> future =
                kafkaTemplate.send(topic, obj);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, byte[]> result) {
                log.info("Sent message with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send messag due to : " + ex.getMessage());
            }
        });
    }

}
