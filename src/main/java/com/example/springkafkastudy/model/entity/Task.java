package com.example.springkafkastudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    private UUID id;
    private String name;
    private String description;
    private Instant time;

}
