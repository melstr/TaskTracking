package ru.mels.tasktracking.service.mapper;

import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;

public interface ProjectMapper {
    Project fromRequestDto(ProjectRequestDto projectRequestDto);

    ProjectResponseDto toResponseDto(Project source);

    Project merge(Project target, Project source);
}
