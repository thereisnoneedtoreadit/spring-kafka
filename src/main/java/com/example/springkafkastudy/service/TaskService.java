package com.example.springkafkastudy.service;

import com.example.springkafkastudy.model.dto.TaskDto;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public TaskDto create(TaskDto task) {
        return task;
    }

}
