package ru.mels.tasktracking.mapper;

import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.entity.Task;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface TaskMapper {
    Task fromRequestDto(TaskRequestDto taskRequestDto);

    TaskResponseDto toResponseDto(Task task);

    Task merge(Task target, Task source);
}
