package com.training.sparrow.frame.interceptor;

import com.training.sparrow.frame.resource.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class, Throwable.class})
    @ResponseBody
    public Response handlerException(Exception e) {
        return Response.NewErrorResponse(e);
    }

}
