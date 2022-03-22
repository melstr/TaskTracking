package ru.mels.tasktracking.service.mapper;

import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.entity.Task;

public interface TaskMapper {
    Task fromRequestDto(TaskRequestDto taskRequestDto);

    TaskResponseDto toResponseDto(Task task);

    Task merge(Task target, Task source);
}
