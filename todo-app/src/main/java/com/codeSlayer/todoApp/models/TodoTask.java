package com.codeSlayer.todoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TodoTask {
    @Id
    @GeneratedValue(strategy = Ge)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdTimestamp;
    private LocalDateTime dueDateTimestamp;
}
