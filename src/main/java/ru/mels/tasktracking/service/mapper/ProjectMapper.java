package ru.mels.tasktracking.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface ProjectMapper {
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "taskBoard", ignore = true)
    Project fromRequestDto(ProjectRequestDto projectRequestDto);

    ProjectResponseDto toResponseDto(Project source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Project merge(@MappingTarget Project target, Project source);
}
