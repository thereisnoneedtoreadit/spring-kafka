package com.example.springkafkastudy.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface TaskRepository extends ReactiveMongoRepository<Profile, UUID> {
}
