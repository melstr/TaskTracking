package ru.mels.tasktracking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Task Tracking",
        version = "1.0",
        description = "Service allows to manage project's tasks."))
public class SwaggerConfiguration {
}