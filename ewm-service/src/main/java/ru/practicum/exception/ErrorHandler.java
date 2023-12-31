package ru.practicum.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleNotFoundException(final NotFoundException e) {
        log.error("Код ошибки:{404},{201}",HttpStatus.NOT_FOUND,e.getMessage());
        return Map.of("status","NOT_FOUND",
                "reason","NOT FOUND",
                "message",e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleThrowable(final ValidationException e) {
        log.error("Код ошибки:{400}",HttpStatus.BAD_REQUEST,e.getMessage());
        return Map.of("status","BAD_REQUEST",
                "reason","BAD REQUEST",
                "message",e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleThrowable(final MethodArgumentNotValidException e) {
        log.error("Код ошибки:{400}",HttpStatus.BAD_REQUEST,e.getMessage());
        return Map.of("status","BAD_REQUEST",
                "reason","BAD REQUEST",
                "message",e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String,String> handleEmailExistException(final ConstraintViolationException e) {
        log.error("Код ошибки:{409}",HttpStatus.CONFLICT,e.getMessage());
        return Map.of("status","CONFLICT",
                "reason","CONFLICT",
                "message",e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String,String> handleEmailExistException(final ConflictException e) {
        log.error("Код ошибки:{409}",HttpStatus.CONFLICT,e.getMessage());
        return Map.of("status","CONFLICT",
                "reason","CONFLICT",
                "message",e.getMessage());
    }
}