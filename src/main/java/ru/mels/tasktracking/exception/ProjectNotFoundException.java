package ru.mels.tasktracking.exception;

public class ProjectNotFoundException extends NotFoundElementException{

    public ProjectNotFoundException(Long id) {
        super("Project with id - " + id + " is not found");
    }
}
