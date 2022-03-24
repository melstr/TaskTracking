package ru.mels.tasktracking.service;

import org.springframework.data.domain.Page;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.dto.filter.TaskFilterDto;
import ru.mels.tasktracking.enums.TaskStatus;

import java.util.List;


public interface TaskService {
    /**
     * Gets a task by it's id
     * @param id task id
     * @return DTO with info about the task
     */
    TaskResponseDto findById(Long id);

    /**
     * Creates a task and assigns it to an employee
     *
     * @param releaseId id of a release that attached to the task
     * @param reporterId id of a creator of the task
     * @param assigneeId id of an employee that should complete the task
     * @param taskRequestDto DTO with information about the task
     * @return DTO with information of a created task
     */
    TaskResponseDto create(Long releaseId,
                           Long reporterId,
                           Long assigneeId,
                           TaskRequestDto taskRequestDto);

    /**
     * Updates information about the task
     *
     * @param taskId id of a task that should be updated
     * @param taskRequestDto DTO with information to update. Nulls are ignored
     * @return DTO of an updated task
     */
    TaskResponseDto update(Long taskId, TaskRequestDto taskRequestDto);

    /**
     * Gets page of tasks that do not have status {@code DONE} in the project
     *
     * @param projectId id of a project
     * @param page number of a page of pageable. Starts with 0.
     * @param size amount of elements (tasks) in 1 page
     * @return page of DTOs with information about unfinished tasks
     */
    Page<TaskResponseDto> findUndoneTasksByProjectId(Long projectId, Integer page, Integer size);

    /**
     * Counts an amount of tasks that do not have status {@code DONE} in the release
     *
     * @param releaseId id of a release
     * @return amount of unfinished tasks
     */
    Long countUndoneTasksByRelease(Long releaseId);

    /**
     * Updates status of a task. It can be {@code BACKLOG, IN_PROGRESS, DONE}.
     * Status cannot be changed if the project is closed.
     *
     * @param taskId id of a task
     * @param status status of a task
     * @return DTO of an updated  task
     */
    TaskResponseDto updateStatus(Long taskId, TaskStatus status);

    /**
     * Finds tasks by filter {@link TaskFilterDto}
     * Uses QueryDSL for dynamically generated JPQLQueries
     *
     * @param taskFilterDto DTO that contains parameters for searching tasks. Unnecessary params should be {@code null}.
     * @return List of DTOs of found tasks
     */
    List<TaskResponseDto> findByFilter(TaskFilterDto taskFilterDto);

    /**
     * Deletes a task by id
     *
     * @param taskId id of a task to delete
     */
    void delete(Long taskId);


}
