package ru.mels.tasktracking.service.mapper.impl;

import org.springframework.stereotype.Component;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.service.mapper.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromRequestDto(TaskRequestDto source) {
        Task task = new Task();
        task.setTitle(source.getTitle());
        task.setDescription(source.getDescription());
        task.setStatus(source.getStatus());
        return task;
    }

    @Override
    public TaskResponseDto toResponseDto(Task source) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTitle(source.getTitle());
        taskResponseDto.setDescription(source.getDescription());
        taskResponseDto.setId(source.getId());
        taskResponseDto.setReleaseId(source.getRelease().getId());
        taskResponseDto.setReporterId(source.getReporter().getId());
        taskResponseDto.setAssigneeId(source.getAssignee().getId());
        taskResponseDto.setStatus(source.getStatus());
        return taskResponseDto;
    }

    @Override
    public Task merge(Task target, Task source) {
        if(source.getTitle() != null){
            target.setTitle(source.getTitle());
        }
        if(source.getDescription() != null){
            target.setTitle(source.getDescription());
        }
        if(source.getStatus() != null){
            target.setStatus(source.getStatus());
        }
        return target;
    }
}