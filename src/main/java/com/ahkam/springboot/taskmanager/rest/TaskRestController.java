package com.ahkam.springboot.taskmanager.rest;

import com.ahkam.springboot.taskmanager.entity.Task;
import com.ahkam.springboot.taskmanager.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/tasks")
public class TaskRestController {

    private TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("")
    public Task addTask(@RequestBody Task task) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        task.setStatus((byte) 0);
        task.setTimestamp(new Date());

        Task dbTask = taskService.save(task);

        return dbTask;
    }

    @GetMapping("")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PutMapping("/update-task-status/{id}")
    public Task updateTaskStatus(@RequestBody Task task, @PathVariable UUID id) {
        Task updateTask = taskService.findById(id);

        updateTask.setStatus(task.getStatus());

        return taskService.save(updateTask);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable UUID id) {
        Task updateTask = taskService.findById(id);

        updateTask.setTask(task.getTask());
        updateTask.setStatus(task.getStatus());
        updateTask.setPriority(task.getPriority());

        return taskService.save(updateTask);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable UUID id) {

        Task task = taskService.findById(id);

        // throw exception if null

        if (task == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        taskService.deleteById(id);

        return "Deleted employee id - " + id;
    }
}