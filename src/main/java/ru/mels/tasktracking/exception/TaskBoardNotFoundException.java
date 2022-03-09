package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardNotFoundException extends NotFoundElementException{
    public TaskBoardNotFoundException(Integer id) {
        super("Task board with id - " + id + " is not found");
    }
}
