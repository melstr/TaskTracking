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
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.mels.tasktracking.dto.TaskRequestDto;
import ru.mels.tasktracking.dto.TaskResponseDto;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author Meleshkin Alexandr
 * @since 08.03.2022
 */
@RequestMapping(path = "tasks")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Task is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Task controller", description = "Task CRUD controller")
public class TaskController {
    @Operation(summary = "Get task by id")
    @ApiResponse(responseCode = "200", description = "Task is found")
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> get(@PathVariable("taskId") Integer id){
        return ResponseEntity.ok(new TaskResponseDto());
    }

    @Operation(summary = "Get task by id")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(new TaskResponseDto());
    }

    @Operation(summary = "Update task by id")
    @ApiResponse(responseCode = "200", description = "Task is created")
    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> update(@PathVariable("taskId") Integer id,
                                                     @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.ok(new TaskResponseDto());
    }

    @Operation(summary = "Delete task by id")
    @ApiResponse(responseCode = "204", description = "Task is deleted")
    @DeleteMapping("/{taskId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("taskId") Integer id){

    }
}
