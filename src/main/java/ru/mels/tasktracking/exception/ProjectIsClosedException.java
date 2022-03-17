package ru.mels.tasktracking.exception;

public class ProjectIsClosedException extends AppException{
    public ProjectIsClosedException(Long projectId) {
        super("You can't change state of the project with id - " + projectId + " because it was closed");
    }
}
