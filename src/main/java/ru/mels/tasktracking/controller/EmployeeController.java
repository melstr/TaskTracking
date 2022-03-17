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
import ru.mels.tasktracking.service.EmployeeService;


import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequestMapping
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "Employee is not found")
@ApiResponse(responseCode = "400", description = "Validation failed")
@Tag(name = "Employee controller", description = "Employee CRUD controller")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Operation(summary = "Get employee by id")
    @ApiResponse(responseCode = "200", description = "Employee is found")
    @GetMapping(Urls.Employee.Id.FULL)
    public ResponseEntity<EmployeeResponseDto> findById(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.findById(employeeId));
    }

    @Operation(summary = "Create employee")
    @ApiResponse(responseCode = "200", description = "Employee is created")
    @PostMapping(Urls.Employee.FULL)
    public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeRequestDto employeeRequestDto){
        return ResponseEntity.ok(employeeService.create(employeeRequestDto));
    }

    @Operation(summary = "Update employee by id")
    @ApiResponse(responseCode = "200", description = "Employee is created")
    @PatchMapping(Urls.Employee.Id.FULL)
    public ResponseEntity<EmployeeResponseDto> update(@PathVariable Long employeeId,
                                                      @RequestBody EmployeeRequestDto employeeRequestDto){
        return ResponseEntity.ok(employeeService.update(employeeId, employeeRequestDto));
    }

    @Operation(summary = "Delete employee by id")
    @ApiResponse(responseCode = "204", description = "Employee is deleted")
    @DeleteMapping(Urls.Employee.Id.FULL)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long employeeId){
        employeeService.delete(employeeId);
    }


}
