package ru.mels.tasktracking.exception;

public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String message){
        super(message);
    }
}
