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
import org.springframework.web.bind.annotation.RestController;
import ru.mels.tasktracking.dto.TaskBoardRequestDto;
import ru.mels.tasktracking.dto.TaskBoardResponseDto;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author Meleshkin Alexandr
 * @since 08.03.2022
 */
@RestController
@RequestMapping(path = "task_boards")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "TaskBoard is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "TaskBoard controller", description = "TaskBoard CRUD controller")
public class TaskBoardController {
    @Operation(summary = "Get task board by id")
    @ApiResponse(responseCode = "200", description = "Task board is found")
    @GetMapping("/{taskBoardId}")
    public ResponseEntity<TaskBoardResponseDto> get(@PathVariable("taskBoardId") Integer id){
        return ResponseEntity.ok(new TaskBoardResponseDto());
    }

    @Operation(summary = "Get task board by id")
    @ApiResponse(responseCode = "200", description = "Task board is created")
    @PostMapping
    public ResponseEntity<TaskBoardResponseDto> create(@RequestBody TaskBoardRequestDto taskBoardRequestDto){
        return ResponseEntity.ok(new TaskBoardResponseDto());
    }

    @Operation(summary = "Update task board by id")
    @ApiResponse(responseCode = "200", description = "Task board is created")
    @PatchMapping("/{taskBoardId}")
    public ResponseEntity<TaskBoardResponseDto> update(@PathVariable("taskBoardId") Integer id,
                                                     @RequestBody TaskBoardRequestDto taskBoardRequestDto){
        return ResponseEntity.ok(new TaskBoardResponseDto());
    }

    @Operation(summary = "Delete task board by id")
    @ApiResponse(responseCode = "204", description = "Task board is deleted")
    @DeleteMapping("/{taskBoardId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("taskBoardId") Integer id){

    }
}
