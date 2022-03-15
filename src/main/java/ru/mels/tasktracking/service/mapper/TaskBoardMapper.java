package ru.mels.tasktracking.service.mapper;

import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.entity.TaskBoard;

public interface TaskBoardMapper {
    TaskBoard fromRequestDto(TaskBoardRequestDto taskBoardRequestDto);

    TaskBoardResponseDto toResponseDto(TaskBoard taskBoard);

    TaskBoard merge(TaskBoard target, TaskBoard source);
}
