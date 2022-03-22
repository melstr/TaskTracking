package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;


public interface EmployeeService {
    EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto get(Long id);

    EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto);

    void delete(Long id);
}
