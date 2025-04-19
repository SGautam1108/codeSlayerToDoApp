package com.codeSlayer.todoApp.controllers;

import com.codeSlayer.todoApp.domain.TodoTask;
import com.codeSlayer.todoApp.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<List<TodoTask>> getTasks(){
        // this will call service and return all tasks fetched
        List<TodoTask> tasksList = taskService.getAllTasks();
        return ResponseEntity.ok(tasksList);
    }
}
