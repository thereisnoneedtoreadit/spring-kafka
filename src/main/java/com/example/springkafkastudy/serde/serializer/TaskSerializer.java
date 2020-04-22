package com.example.springkafkastudy.serde.serializer;

import com.example.springkafkastudy.model.dto.TaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class TaskSerializer implements Serializer<TaskDto> {

    private final ObjectMapper mapper;

    public TaskSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void close() {
    }

    @SneakyThrows
    @Override
    public byte[] serialize(TaskDto obj) {
        return mapper.writeValueAsBytes(obj);
    }

}
