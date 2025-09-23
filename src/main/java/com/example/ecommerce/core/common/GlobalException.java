package com.example.ecommerce.core.common;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalException extends ResponseEntityExceptionHandler{

    private boolean stackTrace;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorResponse handleBadRequestException(Exception ex, WebRequest request){
        List<StackTraceElement> stackTraces = null;
        if (stackTrace){
            stackTraces = Arrays.asList(ex.getStackTrace());
        }
        return new ErrorResponse(stackTraces, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
