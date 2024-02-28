package com.viktorkuts.eventplanner.utils;

import com.viktorkuts.eventplanner.utils.exceptions.InUseException;
import com.viktorkuts.eventplanner.utils.exceptions.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, WebRequest request, Exception ex){
        final String path = request.getDescription(false);
        final String message = ex.getMessage();
        log.debug("[HttpErrorInfo] {}: {} ({})", httpStatus, message, path);
        return new HttpErrorInfo(httpStatus, path, message);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public HttpErrorInfo handleNotFound(WebRequest request, Exception ex){
        return createHttpErrorInfo(HttpStatus.NOT_FOUND, request, ex);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public HttpErrorInfo handleInvalidInputException(WebRequest request, Exception ex){
        return createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, request, ex);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InUseException.class)
    public HttpErrorInfo handleInUse(WebRequest request, Exception ex){
        return createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, request, ex);
    }
}
