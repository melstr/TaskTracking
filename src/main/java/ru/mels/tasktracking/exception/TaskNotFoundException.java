package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskNotFoundException extends NotFoundElementException{
    public TaskNotFoundException(Integer id) {
        super("Task with id - " + id + " is not found");
    }
}
