package com.example.answeroom.controller;


import com.example.answeroom.exception.ErrStackTrace;
import com.example.answeroom.exception.RestError;
import lombok.extern.log4j.Log4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestError.class)
    public ResponseEntity<ErrStackTrace> handleRestError(RestError ex) {
        logger.error("7kni4sf8q9 :: error_type=" + ex.error_type + " : " + ex.getMessage(), ex);

        return ResponseEntity.status(ex.statusCode)
                .header("error_type", ex.getClass().getSimpleName())
                .body(ErrStackTrace.from(ex, true));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrStackTrace> handle(Exception ex) {
        logger.error("UCoEEBe6M6 :: " + ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .header("error_type", ex.getClass().getSimpleName())
                .body(ErrStackTrace.from(ex));
    }

    @ExceptionHandler(ClientAbortException.class)
    public void handle(ClientAbortException ex) {
        logger.error("GItULznIxE :: " + ex.getMessage(), ex);
    }

}

