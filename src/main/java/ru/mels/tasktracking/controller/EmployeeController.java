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
import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;


import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author Meleshkin Alexandr
 * @since 08.03.2022
 */
@RestController
@RequestMapping(path = "employees")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Employee is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Employee controller", description = "Employee CRUD controller")
public class EmployeeController {
    @Operation(summary = "Get employee by id")
    @ApiResponse(responseCode = "200", description = "Employee is found")
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> get(@PathVariable("employeeId") Integer id){
        return ResponseEntity.ok(new EmployeeResponseDto());
    }

    @Operation(summary = "Get employee by id")
    @ApiResponse(responseCode = "200", description = "Employee is created")
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeRequestDto employeeRequestDto){
        return ResponseEntity.ok(new EmployeeResponseDto());
    }

    @Operation(summary = "Update employee by id")
    @ApiResponse(responseCode = "200", description = "Employee is created")
    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> update(@PathVariable("employeeId") Integer id,
                                                      @RequestBody EmployeeRequestDto employeeRequestDto){
        return ResponseEntity.ok(new EmployeeResponseDto());
    }

    @Operation(summary = "Delete employee by id")
    @ApiResponse(responseCode = "204", description = "Employee is deleted")
    @DeleteMapping("/{employeeId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("employeeId") Integer id){

    }


}
