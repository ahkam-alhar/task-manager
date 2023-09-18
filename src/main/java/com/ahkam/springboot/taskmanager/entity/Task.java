package com.ahkam.springboot.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "task")
    private String task;

    @Column(name = "priority")
    private byte priority;

    @Column(name = "status")
    private byte status;

    @Column(name = "timestamp")
    private Date timestamp;
}
