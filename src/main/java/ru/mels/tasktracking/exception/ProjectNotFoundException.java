package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class ProjectNotFoundException extends NotFoundElementException{

    public ProjectNotFoundException(Integer id) {
        super("Project with id - " + id + " is not found");
    }
}
