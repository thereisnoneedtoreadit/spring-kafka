package com.example.springkafkastudy.model.dto;

import com.example.springkafkastudy.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String name;
    private String description;
    private Instant time;

    public Task asEntity() {
        return new Task(UUID.randomUUID(), this.name, this.description, this.time);
    }

}
