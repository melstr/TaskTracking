package ru.mels.tasktracking.exception;

public class EmployeeNotFoundException extends NotFoundElementException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with id - " + id + " is not found");
    }
}
