package ru.mels.tasktracking.mapper;

import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface ProjectMapper {
    Project fromRequestDto(ProjectRequestDto projectRequestDto);

    ProjectResponseDto toResponseDto(Project project);

    Project merge(Project target, Project source);
}
