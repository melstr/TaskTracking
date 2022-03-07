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
import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author Meleshkin Alexandr
 * @since 08.03.2022
 */
@RestController
@RequestMapping(path = "releases")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Release is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Release controller", description = "Release CRUD controller")
public class ReleaseController {
    @Operation(summary = "Get release by id")
    @ApiResponse(responseCode = "200", description = "Release is found")
    @GetMapping("/{releaseId}")
    public ResponseEntity<ReleaseResponseDto> get(@PathVariable("releaseId") Integer id){
        return ResponseEntity.ok(new ReleaseResponseDto());
    }

    @Operation(summary = "Get release by id")
    @ApiResponse(responseCode = "200", description = "Release is created")
    @PostMapping
    public ResponseEntity<ReleaseResponseDto> create(@RequestBody ReleaseRequestDto releaseRequestDto){
        return ResponseEntity.ok(new ReleaseResponseDto());
    }

    @Operation(summary = "Update release by id")
    @ApiResponse(responseCode = "200", description = "Release is created")
    @PatchMapping("/{releaseId}")
    public ResponseEntity<ReleaseResponseDto> update(@PathVariable("releaseId") Integer id,
                                                      @RequestBody ReleaseRequestDto releaseRequestDto){
        return ResponseEntity.ok(new ReleaseResponseDto());
    }

    @Operation(summary = "Delete release by id")
    @ApiResponse(responseCode = "204", description = "Release is deleted")
    @DeleteMapping("/{releaseId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("releaseId") Integer id){

    }
}
