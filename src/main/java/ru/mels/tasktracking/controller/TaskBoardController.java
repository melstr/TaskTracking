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
import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;
import ru.mels.tasktracking.service.TaskBoardService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "TaskBoard is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "TaskBoard controller", description = "TaskBoard CRUD controller")
public class TaskBoardController {
    private final TaskBoardService taskBoardService;

    public TaskBoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @Operation(summary = "Get task board by id")
    @ApiResponse(responseCode = "200", description = "Task board is found")
    @GetMapping(Urls.TaskBoard.Id.FULL)
    public ResponseEntity<TaskBoardResponseDto> findById(@PathVariable Long taskBoardId){
        return ResponseEntity.ok(taskBoardService.findById(taskBoardId));
    }

    @Operation(summary = "Create task board")
    @ApiResponse(responseCode = "200", description = "Task board is created")
    @PostMapping(Urls.TaskBoard.FULL)
    public ResponseEntity<TaskBoardResponseDto> create(@RequestBody TaskBoardRequestDto taskBoardRequestDto,
                                                       @RequestParam Long projectId){
        return ResponseEntity.ok(taskBoardService.create(projectId, taskBoardRequestDto));
    }

    @Operation(summary = "Update task board by id")
    @ApiResponse(responseCode = "200", description = "Task board is created")
    @PatchMapping(Urls.TaskBoard.Id.FULL)
    public ResponseEntity<TaskBoardResponseDto> update(@PathVariable Long taskBoardId,
                                                       @RequestBody TaskBoardRequestDto taskBoardRequestDto){
        return ResponseEntity.ok(taskBoardService.update(taskBoardId, taskBoardRequestDto));
    }

    @Operation(summary = "Delete task board by id")
    @ApiResponse(responseCode = "204", description = "Task board is deleted")
    @DeleteMapping(Urls.TaskBoard.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long taskBoardId){
        taskBoardService.delete(taskBoardId);
    }
}
