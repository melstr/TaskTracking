package ru.mels.tasktracking.exception;

public class ReleaseNotFoundException extends NotFoundElementException{
    public ReleaseNotFoundException(Long id) {
        super("Release with id - " + id + " is not found");
    }
}
