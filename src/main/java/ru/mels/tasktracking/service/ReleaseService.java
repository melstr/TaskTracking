package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;


public interface ReleaseService {
    /**
     * Gets an info of a release by its id
     *
     * @param id id of a release
     * @return DTO of a release
     */
    ReleaseResponseDto findById(Long id);

    /**
     * Creates a release for a project.
     *
     * @param taskBoardId id of a task board
     * @param releaseRequestDto DTO with information of a release
     * @return DTO with created release
     */
    ReleaseResponseDto create(Long taskBoardId, ReleaseRequestDto releaseRequestDto);

    /**
     * Updates information about release
     *
     * @param id id of a release
     * @param releaseRequestDto DTO of a release. Nulls are ignored
     * @return DTO of an updated release
     */
    ReleaseResponseDto update(Long id, ReleaseRequestDto releaseRequestDto);

    /**
     * Deletes a release by id
     * @param id id of a release
     */
    void delete(Long id);
}
