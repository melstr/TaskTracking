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
import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author Meleshkin Alexandr
 * @since 08.03.2022
 */
@RestController
@RequestMapping(path = "projects")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Project is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Project controller", description = "Project CRUD controller")
public class ProjectController {
    @Operation(summary = "Get project by id")
    @ApiResponse(responseCode = "200", description = "Project is found")
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponseDto> get(@PathVariable("projectId") Integer id){
        return ResponseEntity.ok(new ProjectResponseDto());
    }

    @Operation(summary = "Get project by id")
    @ApiResponse(responseCode = "200", description = "Project is created")
    @PostMapping
    public ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(new ProjectResponseDto());
    }

    @Operation(summary = "Update project by id")
    @ApiResponse(responseCode = "200", description = "Project is created")
    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectResponseDto> update(@PathVariable("projectId") Integer id,
                                                      @RequestBody ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(new ProjectResponseDto());
    }

    @Operation(summary = "Delete project by id")
    @ApiResponse(responseCode = "204", description = "Project is deleted")
    @DeleteMapping("/{projectId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("projectId") Integer id){

    }
}
