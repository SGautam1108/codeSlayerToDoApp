package com.codeSlayer.todoApp.exceptions;

public class TodoTaskNotFoundException extends RuntimeException {
    public TodoTaskNotFoundException(String message) {
        super(message);
    }
}
