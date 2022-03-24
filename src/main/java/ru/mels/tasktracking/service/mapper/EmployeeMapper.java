package ru.mels.tasktracking.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;
import ru.mels.tasktracking.entity.Employee;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "createdTasks", ignore = true)
    @Mapping(target = "assignedTasks", ignore = true)
    Employee fromRequestDto(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto toResponseDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Employee merge(@MappingTarget Employee target, Employee source);
}
