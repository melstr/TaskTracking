package ru.mels.tasktracking.mapper;

import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.entity.TaskBoard;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface TaskBoardMapper {
    TaskBoard fromRequestDto(TaskBoardRequestDto taskBoardRequestDto);

    TaskBoardResponseDto toResponseDto(TaskBoard taskBoard);

    TaskBoard merge(TaskBoard target, TaskBoard source);
}
