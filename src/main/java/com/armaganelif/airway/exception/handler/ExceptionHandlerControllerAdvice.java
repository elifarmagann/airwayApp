package com.armaganelif.airway.exception.handler;

import com.armaganelif.airway.exception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(final Exception exception) {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(exception.getMessage());
        errorResponse.setType(exception.getClass().getSimpleName());

        log.error(exception.toString());

        final ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);

        return new ResponseEntity(errorResponse, responseStatus.value());
    }
}