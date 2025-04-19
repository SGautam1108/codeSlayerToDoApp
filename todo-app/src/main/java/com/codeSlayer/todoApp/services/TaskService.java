package com.codeSlayer.todoApp.services;

import com.codeSlayer.todoApp.repository.TaskRepository;
import com.codeSlayer.todoApp.models.TodoTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TodoTask> getAllTasks(){
        List<TodoTask> tasksList = taskRepository.fetchAllTasks();
        return tasksList;
    }
}
