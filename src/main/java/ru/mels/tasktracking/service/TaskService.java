package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;

/**
 * @author Meleshkin Alexandr
 * @since 14.03.2022
 */
public interface TaskService {
    TaskResponseDto get(Long id);

    TaskResponseDto create(Long releaseId,
                           Long reporterId,
                           Long assigneeId,
                           TaskRequestDto taskRequestDto);

    TaskResponseDto update(Long taskId, TaskRequestDto taskRequestDto);

    void delete(Long taskId);
}
