package ru.mels.tasktracking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import ru.mels.tasktracking.enums.TaskStatus;
import ru.mels.tasktracking.repository.TaskRepository;
import ru.mels.tasktracking.service.TaskService;
import ru.mels.tasktracking.service.mapper.TaskMapper;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<TaskResponseDto> get(@PathVariable(Urls.Task.Id.NAME) Long id){
        return ResponseEntity.ok(taskService.get(id));
    }

    @Operation(summary = "Create task")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PostMapping(Urls.Task.FULL)
    public ResponseEntity<TaskResponseDto> create(@RequestParam("release_id") Long releaseId,
                                                  @RequestParam("reporter_id") Long reporterId,
                                                  @RequestParam("assignee_id") Long assignee_id,
                                                  @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.create(releaseId, reporterId, assignee_id, taskRequestDto));
    }

    @Operation(summary = "Update task by id")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PatchMapping(Urls.Task.Id.FULL)
    public ResponseEntity<TaskResponseDto> update(@PathVariable(Urls.Task.Id.NAME) Long id,
                                                  @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(taskService.update(id, taskRequestDto));
    }

    @Operation(summary = "Delete task by id")
    @ApiResponse(responseCode = "204", description = "Task is deleted")
    @DeleteMapping(Urls.Task.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable(Urls.Task.Id.NAME) Long id){
        taskService.delete(id);
    }


}
