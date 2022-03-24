package ru.mels.tasktracking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;
import ru.mels.tasktracking.dto.filter.TaskFilterDto;
import ru.mels.tasktracking.enums.TaskStatus;
import ru.mels.tasktracking.service.TaskService;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Task is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Task controller", description = "Task CRUD controller")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get task by id")
    @ApiResponse(responseCode = "200", description = "Task is found")
    @GetMapping(Urls.Task.Id.FULL)
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.findById(taskId));
    }

    @Operation(summary = "Create task")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PostMapping(Urls.Task.FULL)
    public ResponseEntity<TaskResponseDto> create(@RequestParam Long releaseId,
                                                  @RequestParam Long reporterId,
                                                  @RequestParam Long assignee_id,
                                                  @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.create(releaseId, reporterId, assignee_id, taskRequestDto));
    }

    @Operation(summary = "Update task by id")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PatchMapping(Urls.Task.Id.FULL)
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long taskId,
                                                  @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.update(taskId, taskRequestDto));
    }

    @Operation(summary = "Delete task by id")
    @ApiResponse(responseCode = "204", description = "Task is deleted")
    @DeleteMapping(Urls.Task.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long taskId){
        taskService.delete(taskId);
    }

    @Operation(summary = "Get all unfinished tasks by project id")
    @ApiResponse(responseCode = "200", description = "Tasks found")
    @GetMapping(Urls.Project.Id.Task.FULL)
    public ResponseEntity<Page<TaskResponseDto>> getAllUnfinishedTasks(@PathVariable Long projectId,
                                                                       @RequestParam Integer page,
                                                                       @RequestParam Integer size){
        return ResponseEntity.ok(taskService.findUndoneTasksByProjectId(projectId, page, size));
    }

    @Operation(summary = "Get count of unfinished tasks by release id")
    @ApiResponse(responseCode = "200", description = "Tasks found")
    @GetMapping(Urls.Release.Id.Task.FULL)
    public ResponseEntity<Long> countAllUnfinishedTasks(@PathVariable Long releaseId){
        return ResponseEntity.ok(taskService.countUndoneTasksByRelease(releaseId));
    }

    @Operation(summary = "Update task status")
    @ApiResponse(responseCode = "200", description = "Task status is updated")
    @PatchMapping(Urls.Task.Id.Status.FULL)
    public ResponseEntity<TaskResponseDto> changeTaskStatus(@PathVariable Long taskId,
                                                            @RequestParam TaskStatus status){
        return ResponseEntity.ok(taskService.updateStatus(taskId, status));
    }

    @Operation(summary = "Get all tasks by filter")
    @ApiResponse(responseCode = "200", description = "Tasks found")
    @GetMapping(Urls.Task.FILTER)
    public ResponseEntity<List<TaskResponseDto>> getAllByFilter(@RequestParam(required = false) Long projectID,
                                                                @RequestParam(required = false) Long assigneeID,
                                                                @RequestParam(required = false) Long reporterID,
                                                                @RequestParam(required = false) TaskStatus taskStatus,
                                                                @RequestParam(required = false) Long taskBoardId,
                                                                @RequestParam(required = false) Long releaseId,
                                                                @RequestParam(required = false) String title,
                                                                @RequestParam(required = false) String description){
        TaskFilterDto taskFilterDto = new TaskFilterDto();
        taskFilterDto.setStatus(taskStatus);
        taskFilterDto.setProjectID(projectID);
        taskFilterDto.setAssigneeId(assigneeID);
        taskFilterDto.setReporterId(reporterID);
        taskFilterDto.setTaskBoardID(taskBoardId);
        taskFilterDto.setReleaseId(releaseId);
        taskFilterDto.setTitle(title);
        taskFilterDto.setDescription(description);
        return ResponseEntity.ok(taskService.findByFilter(taskFilterDto));
    }
}
