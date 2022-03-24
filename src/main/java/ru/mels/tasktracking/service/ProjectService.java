package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.enums.ProjectStatus;

public interface ProjectService {
    /**
     * Creates project in database
     *
     * @param projectRequestDto DTO with information of a project
     * @return DTO with information of a created project
     */
    ProjectResponseDto create(ProjectRequestDto projectRequestDto);

    /**
     * Gets an information about the project from database
     *
     * @param id id of a project
     * @return DTO with info about project
     */
    ProjectResponseDto findById(Long id);

    /**
     * Updates information about project
     * @param id id of a project
     * @param projectRequestDto DTO with info needs to be changed in projects. Nulls are ignored
     * @return DTO of an updated project
     */
    ProjectResponseDto update(Long id, ProjectRequestDto projectRequestDto);

    /**
     * Deletes a project from database by id
     * @param id id of a project
     */
    void delete(Long id);

    /**
     * Updates status of the project. If there are any tasks in the project with status {@code DONE},
     * exception will be thrown
     *
     * @param id id of a project
     * @param projectStatus new status of a project
     * @return DTO of an updated project
     */
    ProjectResponseDto updateStatus(Long id, ProjectStatus projectStatus);
}
