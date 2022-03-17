package ru.mels.tasktracking.exception;

/**
 * @author Meleshkin Alexandr
 * @since 17.03.2022
 */
public class AppException extends RuntimeException{
    public AppException(String message){
        super(message);
    }
}
