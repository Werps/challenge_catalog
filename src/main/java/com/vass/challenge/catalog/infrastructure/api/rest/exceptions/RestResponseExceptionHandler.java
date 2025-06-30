package com.vass.challenge.catalog.infrastructure.api.rest.exceptions;

import com.vass.challenge.catalog.application.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex){
        log.info("Handling not found exception: {}", ex.getMessage());
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

}
