package com.codeSlayer.todoApp.controllers;

import com.codeSlayer.todoApp.domain.TodoTask;
import com.codeSlayer.todoApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    protected TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<List<TodoTask>> getAllTasks(){
        try{
            List<TodoTask> tasksList = taskService.getAllTasks();
            return ResponseEntity.ok(tasksList);
        } catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/tasks/{id}")
    public ResponseEntity<TodoTask> getTaskById(@PathVariable("id") Long taskId){
        try{
            TodoTask foundTask = taskService.getTaskById(taskId);
            return ResponseEntity.ok(foundTask);
        } catch(NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        } catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<TodoTask> addTask(@RequestBody TodoTask todoTask){
        try{
            TodoTask savedTask = taskService.addTask(todoTask);
            return ResponseEntity.ok(savedTask);
        } catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping(path = "/tasks/{id}")
    public ResponseEntity<TodoTask> updateTask(@PathVariable("id") Long taskId, @RequestBody TodoTask task){
        try{
            TodoTask savedTask = taskService.updateTask(taskId, task);
            return ResponseEntity.ok(savedTask);
        } catch(NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        } catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/tasks/{id}")
    public ResponseEntity<TodoTask> deleteTask(@PathVariable("id") Long taskId){
        try{
            TodoTask deletedTask = taskService.deleteTask(taskId);
            return ResponseEntity.ok(deletedTask);
        } catch(NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        } catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
