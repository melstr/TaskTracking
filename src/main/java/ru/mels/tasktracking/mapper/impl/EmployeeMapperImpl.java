package ru.mels.tasktracking.mapper.impl;

import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;
import ru.mels.tasktracking.entity.Employee;
import ru.mels.tasktracking.mapper.EmployeeMapper;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee fromRequestDto(EmployeeRequestDto source) {
        Employee employee = new Employee();
        employee.setEmail(source.getEmail());
        employee.setNickname(source.getNickname());
        employee.setPassword(source.getPassword());
        return employee;
    }

    @Override
    public EmployeeResponseDto toResponseDto(Employee source) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setEmail(source.getEmail());
        employeeResponseDto.setId(source.getId());
        employeeResponseDto.setNickname(source.getNickname());
        employeeResponseDto.setPassword(source.getPassword());
        return employeeResponseDto;
    }

    @Override
    public Employee merge(Employee target, Employee source) {
        if(source.getEmail() != null){
            target.setEmail(source.getEmail());
        }
        if(source.getNickname() != null){
            target.setNickname(source.getNickname());
        }
        if(source.getPassword() != null){
            target.setPassword(source.getPassword());
        }
        return target;
    }
}
