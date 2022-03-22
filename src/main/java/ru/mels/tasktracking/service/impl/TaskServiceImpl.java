package ru.mels.tasktracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.exception.EmployeeNotFoundException;
import ru.mels.tasktracking.exception.ReleaseNotFoundException;
import ru.mels.tasktracking.exception.TaskNotFoundException;
import ru.mels.tasktracking.repository.EmployeeRepository;
import ru.mels.tasktracking.repository.ReleaseRepository;
import ru.mels.tasktracking.repository.TaskRepository;
import ru.mels.tasktracking.service.TaskService;
import ru.mels.tasktracking.service.mapper.TaskMapper;

/**
 * @author Meleshkin Alexandr
 * @since 14.03.2022
 */
@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final ReleaseRepository releaseRepository;
    private final EmployeeRepository employeeRepository;

    public TaskServiceImpl(TaskMapper taskMapper,
                           TaskRepository taskRepository,
                           ReleaseRepository releaseRepository,
                           EmployeeRepository employeeRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
        this.releaseRepository = releaseRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public TaskResponseDto get(Long id) {
        return taskMapper.toResponseDto(taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    @Override
    @Transactional
    public TaskResponseDto create(Long releaseId, Long reporterId, Long assigneeId, TaskRequestDto taskRequestDto) {
        Task task = taskMapper.fromRequestDto(taskRequestDto);
        task.setRelease(releaseRepository.findById(releaseId)
                .orElseThrow(() -> new ReleaseNotFoundException(releaseId)));
        task.setReporter(employeeRepository.findById(reporterId)
                .orElseThrow(() -> new EmployeeNotFoundException(reporterId)));
        task.setAssignee(employeeRepository.findById(assigneeId)
                .orElseThrow(() -> new EmployeeNotFoundException(assigneeId)));
        return taskMapper.toResponseDto(taskRepository.save(task));
    }

    @Override
    @Transactional
    public TaskResponseDto update(Long taskId, TaskRequestDto taskRequestDto) {
        Task current = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        Task toUpdate = taskMapper.merge(current, taskMapper.fromRequestDto(taskRequestDto));
        return taskMapper.toResponseDto(taskRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long taskId) {
        taskRepository.delete(taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }
}
