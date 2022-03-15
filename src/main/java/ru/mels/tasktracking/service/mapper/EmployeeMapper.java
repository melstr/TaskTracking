package ru.mels.tasktracking.service.mapper;

import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;
import ru.mels.tasktracking.entity.Employee;

public interface EmployeeMapper {
    Employee fromRequestDto(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto toResponseDto(Employee employee);

    Employee merge(Employee target, Employee source);
}
