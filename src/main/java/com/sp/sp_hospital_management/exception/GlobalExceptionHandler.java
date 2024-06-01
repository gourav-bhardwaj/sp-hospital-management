package com.sp.sp_hospital_management.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ProblemDetail handleThrowableException(Throwable ex) {
        log.error("PRINT STACKTRACE : {}", ExceptionUtils.getStackTrace(ex));
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), ex.getMessage());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ProblemDetail handleResponseStatusException(ResponseStatusException rse) {
        log.error("ERROR WHERE : {}, PRINT STACKTRACE : {}", rse.getReason(), ExceptionUtils.getStackTrace(rse.getRootCause()));
        return ProblemDetail.forStatusAndDetail(rse.getStatusCode(), rse.getReason());
    }

}
