package com.codeSlayer.todoApp.services;

import com.codeSlayer.todoApp.repository.TaskRepository;
import com.codeSlayer.todoApp.domain.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    protected TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TodoTask> getAllTasks(){
        return taskRepository.findAll();
    }

    public TodoTask getTaskById(Long taskId){
        return taskRepository.findById(taskId).orElseThrow();
    }

    public TodoTask addTask(TodoTask todoTask){
        return taskRepository.save(todoTask);
    }

    public TodoTask updateTask(Long taskId, TodoTask todoTask){
        TodoTask toUpdateTask = taskRepository.findById(taskId).orElseThrow();

        // Do not update CreateTimeStamp and id
        toUpdateTask.setTitle(todoTask.getTitle());
        toUpdateTask.setDescription(todoTask.getDescription());
        toUpdateTask.setDueDateTime(todoTask.getDueDateTime());

        return taskRepository.save(toUpdateTask);
    }

    public TodoTask deleteTask(Long taskId) {
        TodoTask toDeleteTask = taskRepository.findById(taskId).orElseThrow();
        taskRepository.deleteById(taskId);
        return toDeleteTask;
    }
}
