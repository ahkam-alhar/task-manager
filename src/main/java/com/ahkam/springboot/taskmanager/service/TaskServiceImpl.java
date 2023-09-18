package com.ahkam.springboot.taskmanager.service;

import com.ahkam.springboot.taskmanager.dao.TaskRepository;
import com.ahkam.springboot.taskmanager.entity.Task;
import com.ahkam.springboot.taskmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(UUID id) {
        /*
        * Once the task is not there, ResourceNotFoundException will be called.
        * If task is available, task will be returned
        */I
        return taskRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Did not find employee id - " + id));
    }

    @Override
    public void deleteById(UUID id) {
        taskRepository.deleteById(id);
    }
}
