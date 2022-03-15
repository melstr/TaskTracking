package ru.mels.tasktracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.entity.TaskBoard;
import ru.mels.tasktracking.exception.ProjectNotFoundException;
import ru.mels.tasktracking.exception.TaskBoardNotFoundException;
import ru.mels.tasktracking.repository.ProjectRepository;
import ru.mels.tasktracking.repository.TaskBoardRepository;
import ru.mels.tasktracking.service.TaskBoardService;
import ru.mels.tasktracking.service.mapper.TaskBoardMapper;

@Service
@Transactional(readOnly = true)
public class TaskBoardServiceImpl implements TaskBoardService {
    private final TaskBoardRepository taskBoardRepository;
    private final TaskBoardMapper taskBoardMapper;
    private final ProjectRepository projectRepository;

    public TaskBoardServiceImpl(TaskBoardRepository taskBoardRepository,
                                TaskBoardMapper taskBoardMapper,
                                ProjectRepository projectRepository) {
        this.taskBoardRepository = taskBoardRepository;
        this.taskBoardMapper = taskBoardMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public TaskBoardResponseDto create(Long projectId, TaskBoardRequestDto taskBoardRequestDto) {
        TaskBoard taskBoard = taskBoardMapper.fromRequestDto(taskBoardRequestDto);
        taskBoard.setProject(projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId)));
        return taskBoardMapper.toResponseDto(taskBoardRepository.save(taskBoard));
    }

    @Override
    public TaskBoardResponseDto get(Long id) {
        return taskBoardRepository.findById(id)
                .map(taskBoardMapper::toResponseDto)
                .orElseThrow(() -> new TaskBoardNotFoundException(id));
    }

    @Override
    @Transactional
    public TaskBoardResponseDto update(Long id, TaskBoardRequestDto taskBoardRequestDto) {
        TaskBoard current = taskBoardRepository.findById(id)
                .orElseThrow(() -> new TaskBoardNotFoundException(id));
        TaskBoard toUpdate = taskBoardMapper.merge(current,
                taskBoardMapper.fromRequestDto(taskBoardRequestDto));
        return taskBoardMapper.toResponseDto(taskBoardRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskBoardRepository.delete(taskBoardRepository.findById(id)
                .orElseThrow(() -> new TaskBoardNotFoundException(id)));
    }
}
