package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;

public interface TaskBoardService {
    TaskBoardResponseDto create(Long projectId, TaskBoardRequestDto taskBoardRequestDto);

    TaskBoardResponseDto get(Long id);

    TaskBoardResponseDto update(Long id, TaskBoardRequestDto taskBoardRequestDto);

    void delete(Long id);
}
