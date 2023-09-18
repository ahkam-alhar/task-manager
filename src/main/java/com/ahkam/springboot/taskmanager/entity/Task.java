package com.ahkam.springboot.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    // Lombok will create all necessary basic coding (Getters, Setters, Construction etc.) for Entity Class

    @Id
    // No need to generate the ID below line will generate ID
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "task")
    @NotNull(message = "task is required")
    @Size(min = 1, max = 254, message = "length should be between 2 and 254")
    private String task;

    @Min(value = -1, message = "value must be -1, 0 or 1")
    @Max(value = 1, message = "value must be -1, 0 or 1")
    @Column(name = "priority")
    private byte priority;

    @Min(value = 0, message = "value must be 0, 1 or 2")
    @Max(value = 2, message = "value must be 0, 1 or 2")
    @Column(name = "status")
    private byte status;

    @Column(name = "timestamp")
    private Date timestamp;
}
