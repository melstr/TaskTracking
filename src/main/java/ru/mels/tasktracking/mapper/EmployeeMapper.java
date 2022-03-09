package ru.mels.tasktracking.mapper;

import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;
import ru.mels.tasktracking.entity.Employee;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface EmployeeMapper {
    Employee fromRequestDto(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto toResponseDto(Employee employee);

    Employee merge(Employee target, Employee source);
}
