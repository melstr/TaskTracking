package ru.mels.tasktracking.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.entity.TaskBoard;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface TaskBoardMapper {
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "releases", ignore = true)
    TaskBoard fromRequestDto(TaskBoardRequestDto taskBoardRequestDto);

    @Mapping(target = "projectId", expression = "java(taskBoard.getProject().getId())")
    TaskBoardResponseDto toResponseDto(TaskBoard taskBoard);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    TaskBoard merge(@MappingTarget TaskBoard target, TaskBoard source);
}
