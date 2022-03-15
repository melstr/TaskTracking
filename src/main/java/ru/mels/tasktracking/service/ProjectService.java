package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.enums.ProjectStatus;

public interface ProjectService {
    ProjectResponseDto create(ProjectRequestDto projectRequestDto);

    ProjectResponseDto get(Long id);

    ProjectResponseDto update(Long id, ProjectRequestDto projectRequestDto);

    void delete(Long id);

    ProjectResponseDto updateStatus(Long id, ProjectStatus projectStatus);
}
