package ru.mels.tasktracking.mapper.impl;

import org.springframework.stereotype.Component;
import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.entity.TaskBoard;
import ru.mels.tasktracking.mapper.TaskBoardMapper;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
@Component
public class TaskBoardMapperImpl implements TaskBoardMapper {
    @Override
    public TaskBoard fromRequestDto(TaskBoardRequestDto source) {
        TaskBoard taskBoard = new TaskBoard();
        taskBoard.setTitle(source.getTitle());
        return taskBoard;
    }

    @Override
    public TaskBoardResponseDto toResponseDto(TaskBoard source) {
        TaskBoardResponseDto taskBoardResponseDto = new TaskBoardResponseDto();
        taskBoardResponseDto.setTitle(source.getTitle());
        taskBoardResponseDto.setId(source.getId());
        taskBoardResponseDto.setProjectId(source.getProject().getId());
        return taskBoardResponseDto;
    }

    @Override
    public TaskBoard merge(TaskBoard target, TaskBoard source) {
        if(source.getTitle() != null){
            target.setTitle(source.getTitle());
        }
        return target;
    }
}
