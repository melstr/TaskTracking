package ru.mels.tasktracking.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.dto.filter.TaskFilterDto;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.enums.TaskStatus;
import ru.mels.tasktracking.exception.EmployeeNotFoundException;
import ru.mels.tasktracking.exception.ProjectIsClosedException;
import ru.mels.tasktracking.exception.ProjectNotFoundException;
import ru.mels.tasktracking.exception.ReleaseNotFoundException;
import ru.mels.tasktracking.exception.TaskNotFoundException;
import ru.mels.tasktracking.repository.EmployeeRepository;
import ru.mels.tasktracking.repository.ProjectRepository;
import ru.mels.tasktracking.repository.ReleaseRepository;
import ru.mels.tasktracking.repository.TaskCustomRepository;
import ru.mels.tasktracking.repository.TaskRepository;
import ru.mels.tasktracking.service.TaskService;
import ru.mels.tasktracking.service.mapper.TaskMapper;

import java.util.List;
import java.util.stream.Collectors;

import static ru.mels.tasktracking.enums.ProjectStatus.CLOSED;

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
    private final ProjectRepository projectRepository;
    private final TaskCustomRepository taskCustomRepository;

    public TaskServiceImpl(TaskMapper taskMapper,
                           TaskRepository taskRepository,
                           ReleaseRepository releaseRepository,
                           EmployeeRepository employeeRepository, ProjectRepository projectRepository, TaskCustomRepository taskCustomRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
        this.releaseRepository = releaseRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.taskCustomRepository = taskCustomRepository;
    }


    @Override
    public TaskResponseDto findById(Long id) {
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
        checkIfProjectIsOpenedElseThrowAnException(current);
        Task toUpdate = taskMapper.merge(current, taskMapper.fromRequestDto(taskRequestDto));
        return taskMapper.toResponseDto(taskRepository.save(toUpdate));
    }

    @Override
    public Page<TaskResponseDto> findUndoneTasksByProjectId(Long projectId, Integer page, Integer size) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        PageRequest pageRequest = PageRequest.of(page, size);
        return taskRepository.getAllUndoneTasksByProjectId(project, pageRequest)
                    .map(taskMapper::toResponseDto);
    }

    @Override
    public Long countUndoneTasksByRelease(Long releaseId) {
        return taskRepository.countByReleaseIdAndStatusNot(releaseId, TaskStatus.DONE);
    }

    @Override
    @Transactional
    public TaskResponseDto updateStatus(Long statusId, TaskStatus status) {
        Task task = taskRepository.findById(statusId).orElseThrow(() -> new TaskNotFoundException(statusId));
        checkIfProjectIsOpenedElseThrowAnException(task);
        task.setStatus(status);
        return taskMapper.toResponseDto(taskRepository.save(task));
    }

    @Override
    public List<TaskResponseDto> findByFilter(TaskFilterDto taskFilterDto) {
        return taskCustomRepository.findByFilter(taskFilterDto)
                .stream()
                .map(taskMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long taskId) {
        taskRepository.delete(taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }

    private void checkIfProjectIsOpenedElseThrowAnException(Task task){
        Project project = projectRepository.getProjectByTask(task);
        if(project.getStatus() == CLOSED){
            throw new ProjectIsClosedException(project.getId());
        }
    }
}
