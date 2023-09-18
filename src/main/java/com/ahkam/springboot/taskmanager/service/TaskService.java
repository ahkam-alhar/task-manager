package com.ahkam.springboot.taskmanager.service;

import com.ahkam.springboot.taskmanager.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task save(Task task);

    List<Task> findAll();

    Task findById(UUID id);

    void deleteById(UUID id);
}
