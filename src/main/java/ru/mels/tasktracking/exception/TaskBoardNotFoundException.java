package ru.mels.tasktracking.exception;

public class TaskBoardNotFoundException extends NotFoundElementException{
    public TaskBoardNotFoundException(Long id) {
        super("Task board with id - " + id + " is not found");
    }
}
