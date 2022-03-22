package ru.mels.tasktracking.exception;

public class TaskNotFoundException extends NotFoundElementException{
    public TaskNotFoundException(Long id) {
        super("Task with id - " + id + " is not found");
    }
}
