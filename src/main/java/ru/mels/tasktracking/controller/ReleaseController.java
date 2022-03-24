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
import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.service.ReleaseService;

import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequestMapping
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Release is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Release controller", description = "Release CRUD controller")
public class ReleaseController {
    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Get release by id")
    @ApiResponse(responseCode = "200", description = "Release is found")
    @GetMapping(Urls.Release.Id.FULL)
    public ResponseEntity<ReleaseResponseDto> findById(@PathVariable Long releaseId) {
        return ResponseEntity.ok(releaseService.findById(releaseId));
    }

    @Operation(summary = "Create release")
    @ApiResponse(responseCode = "200", description = "Release is created")
    @PostMapping(Urls.Release.FULL)
    public ResponseEntity<ReleaseResponseDto> create(@RequestParam("task_board_id") Long taskBoardId,
                                                     @RequestBody ReleaseRequestDto releaseRequestDto) {
        return ResponseEntity.ok(releaseService.create(taskBoardId, releaseRequestDto));
    }

    @Operation(summary = "Update release by id")
    @ApiResponse(responseCode = "200", description = "Release is created")
    @PatchMapping(Urls.Release.Id.FULL)
    public ResponseEntity<ReleaseResponseDto> update(@PathVariable Long releaseId,
                                                     @RequestBody ReleaseRequestDto releaseRequestDto) {
        return ResponseEntity.ok(releaseService.update(releaseId, releaseRequestDto));
    }

    @Operation(summary = "Delete release by id")
    @ApiResponse(responseCode = "204", description = "Release is deleted")
    @DeleteMapping(Urls.Release.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long releaseId) {
        releaseService.delete(releaseId);
    }
}
