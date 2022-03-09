package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */

public class EmployeeNotFoundException extends NotFoundElementException {
    public EmployeeNotFoundException(Integer id) {
        super("Employee with id - " + id + " is not found");
    }
}
