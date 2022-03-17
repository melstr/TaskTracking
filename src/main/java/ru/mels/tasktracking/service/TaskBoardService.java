package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;

public interface TaskBoardService {
    /**
     * Creates a task board for a project. Due to specification 1 project should have only 1 task board
     *
     * @param projectId id of a project
     * @param taskBoardRequestDto DTO with information about task board
     * @return DTO with information about created task board
     */
    TaskBoardResponseDto create(Long projectId, TaskBoardRequestDto taskBoardRequestDto);

    /**
     * Gets information about task board
     *
     * @param id id of a task board
     * @return DTO with information about task board
     */
    TaskBoardResponseDto findById(Long id);

    /**
     * Updates information about task board.
     *
     * @param id id of a task board that should be updated
     * @param taskBoardRequestDto DTO with info of a task board. Nulls are ignored
     * @return DTO of an updated task board
     */
    TaskBoardResponseDto update(Long id, TaskBoardRequestDto taskBoardRequestDto);

    /**
     * Deletes a task board by id
     * @param id id of a task board
     */
    void delete(Long id);
}
