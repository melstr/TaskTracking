package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 17.03.2022
 */
public class CannotCloseTheProjectException extends AppException{
    public CannotCloseTheProjectException(Long projectId, Long undoneProjects) {
        super("The project with id - " + projectId
                + " cannot be closed, because it has "
                + undoneProjects + " undone tasks");
    }
}
