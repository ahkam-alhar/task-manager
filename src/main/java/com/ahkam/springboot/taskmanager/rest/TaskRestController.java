package com.ahkam.springboot.taskmanager.rest;

import com.ahkam.springboot.taskmanager.entity.Task;
import com.ahkam.springboot.taskmanager.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public Task addTask(@RequestBody @Valid Task task) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        // And also set current data and time to timestamp column

        task.setStatus((byte) 0);
        task.setTimestamp(new Date());

        Task dbTask = taskService.save(task);

        return dbTask;
    }

    // This will return all the tasks available in task table
    @GetMapping("")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody @Valid Task task, @PathVariable UUID id) {
        Task updateTask = taskService.findById(id);

        /*
        * set updated task, status and priority to existing task object.
        * Without timestamp and id. These two fields are constant.
        */
        updateTask.setTask(task.getTask());
        updateTask.setStatus(task.getStatus());
        updateTask.setPriority(task.getPriority());

        // Already id is in the updateTask object so, this function will be an update not create.
        return taskService.save(updateTask);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable UUID id) {

        Task task = taskService.findById(id);

        taskService.deleteById(id);

        return "Deleted employee id - " + id;
    }
}
