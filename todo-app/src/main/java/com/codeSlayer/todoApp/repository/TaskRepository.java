package com.codeSlayer.todoApp.repository;

import com.codeSlayer.todoApp.models.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository extends JpaRepository<TodoTask, Long> {
    public List<TodoTask> fetchAllTasks();
}
