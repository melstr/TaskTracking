package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String message){
        super(message);
    }
}
