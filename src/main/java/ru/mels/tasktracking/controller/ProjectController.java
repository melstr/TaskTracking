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
import ru.mels.tasktracking.enums.ProjectStatus;
import ru.mels.tasktracking.service.ProjectService;

import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequestMapping
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Project is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Project controller", description = "Project CRUD controller")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Get project by id")
    @ApiResponse(responseCode = "200", description = "Project is found")
    @GetMapping(Urls.Project.Id.FULL)
    public ResponseEntity<ProjectResponseDto> get(@PathVariable(Urls.Project.Id.NAME) Long id){
       return ResponseEntity.ok(projectService.get(id));
    }

    @Operation(summary = "Create project")
    @ApiResponse(responseCode = "200", description = "Project is created")
    @PostMapping(Urls.Project.FULL)
    public ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.create(projectRequestDto));
    }

    @Operation(summary = "Update project by id")
    @ApiResponse(responseCode = "200", description = "Project is created")
    @PatchMapping(Urls.Project.Id.FULL)
    public ResponseEntity<ProjectResponseDto> update(@PathVariable(Urls.Project.Id.NAME) Long id,
                                                      @RequestBody ProjectRequestDto projectRequestDto){
        return ResponseEntity.ok(projectService.update(id, projectRequestDto));
    }

    @Operation(summary = "Delete project by id")
    @ApiResponse(responseCode = "204", description = "Project is deleted")
    @DeleteMapping(Urls.Project.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable(Urls.Project.Id.NAME) Long id){
        projectService.delete(id);
    }

    @Operation(summary = "Update status of a project")
    @ApiResponse(responseCode = "200", description = "Project status is updated")
    @PatchMapping(Urls.Project.Id.Status.FULL)
    public ResponseEntity<ProjectResponseDto> updateStatus(@PathVariable(Urls.Project.Id.NAME) Long id,
                                                           @RequestBody ProjectStatus projectStatus){
        return ResponseEntity.ok(projectService.updateStatus(id, projectStatus));
    }
}
