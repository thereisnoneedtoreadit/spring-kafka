package com.example.springkafkastudy.serde.deserializer;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class TaskDeserializer implements Deserializer<TaskDto> {

    private final ObjectMapper mapper;

    public TaskDeserializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SneakyThrows
    @Override
    public TaskDto deserialize(byte[] bytes) {
        return mapper.readValue(bytes, TaskDto.class);
    }

    @Override
    public void close() {

    }
}
