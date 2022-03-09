package ru.mels.tasktracking.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mels.tasktracking.exception.NotFoundElementException;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
@ControllerAdvice
public class AbstractRestController {

    @ExceptionHandler(NotFoundElementException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundElementException e){
        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }
}
