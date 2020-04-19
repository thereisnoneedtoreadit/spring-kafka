package com.example.springkafkastudy.repository;

import com.example.springkafkastudy.model.entity.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface TaskRepository extends ReactiveMongoRepository<Task, UUID> {
}
