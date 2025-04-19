package com.codeSlayer.todoApp.repository;

import com.codeSlayer.todoApp.domain.TodoTask;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TodoTask, Long> {

}
