package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;


public interface EmployeeService {
    /**
     * Creates employee in database
     *
     * @param employeeRequestDto DTO with information of an employee
     * @return A DTO of a created employee
     */
    EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto);

    /**
     * Gets employee by id from the database
     *
     * @param id id of an employee
     * @return A DTO of an employee
     */
    EmployeeResponseDto findById(Long id);

    /**
     * Updates info of an employee
     *
     * @param id id of an employee
     * @param employeeRequestDto DTO with information of an employee
     * @return A DTO of an employee
     */
    EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto);

    /**
     * Deletes employee from database
     *
     * @param id id of an employee
     */
    void delete(Long id);
}
