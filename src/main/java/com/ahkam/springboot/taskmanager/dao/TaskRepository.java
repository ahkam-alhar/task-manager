package com.ahkam.springboot.taskmanager.dao;

import com.ahkam.springboot.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findById(@Param(value = "id") UUID id);

    void deleteById(@Param(value = "id") UUID id);
}
