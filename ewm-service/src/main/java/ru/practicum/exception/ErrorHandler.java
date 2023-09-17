package ru.practicum.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(final NotFoundException e) {
        String error = String.format("not found exception: %$", e.getMessage());
        log.info(error);
        return new ErrorResponse(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleThrowable(final ValidationException e) {
        String error = String.format("validation exception: %$", e.getMessage());
        log.info(error);
        return new ErrorResponse(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleThrowable(final MethodArgumentNotValidException e) {
        String error = String.format("method argument exception: %$", e.getMessage());
        log.info(error);
        return new ErrorResponse(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailExistException(final ConstraintViolationException e) {
        String error = String.format("constraint exception: %$", e.getMessage());
        log.info(error);
        return new ErrorResponse(error);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailExistException(final ConflictException e) {
        String error = String.format("conflict exception: %$", e.getMessage());
        log.info(error);
        return new ErrorResponse(error);
    }
}