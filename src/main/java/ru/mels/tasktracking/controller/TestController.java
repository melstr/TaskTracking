package ru.mels.tasktracking.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mels.tasktracking.exception.EmployeeNotFoundException;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
@Tag(name = "Organizer", description = "CRUD controller for Organizers.")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    String getHello(){
        throw new EmployeeNotFoundException(20);
//        return "Hello!";
    }
}
