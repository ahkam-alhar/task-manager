package com.ahkam.springboot.taskmanager.service;

import com.ahkam.springboot.taskmanager.dao.TaskRepository;
import com.ahkam.springboot.taskmanager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Task> result = taskRepository.findById(id);

        Task task = null;

        if (result.isPresent()) {
            task = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return task;
    }

    @Override
    public void deleteById(UUID id) {
        taskRepository.deleteById(id);
    }
}
