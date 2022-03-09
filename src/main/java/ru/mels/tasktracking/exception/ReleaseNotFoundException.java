package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class ReleaseNotFoundException extends NotFoundElementException{
    public ReleaseNotFoundException(Integer id) {
        super("Release with id - " + id + " is not found");
    }
}
