package ru.mels.tasktracking.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "Hello!";
    }
}
