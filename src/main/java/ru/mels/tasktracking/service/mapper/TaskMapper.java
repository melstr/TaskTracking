package ru.mels.tasktracking.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.entity.Task;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface TaskMapper {
    @Mapping(target = "release", ignore = true)
    @Mapping(target = "reporter", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    Task fromRequestDto(TaskRequestDto taskRequestDto);

    @Mapping(target = "releaseId", expression = "java(task.getRelease().getId())")
    @Mapping(target = "assigneeId", expression = "java(task.getAssignee().getId())")
    @Mapping(target = "reporterId", expression = "java(task.getReporter().getId())")
    TaskResponseDto toResponseDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Task merge(@MappingTarget Task target, Task source);
}
