package com.dailycodebuffer.ProductService.exception;

import com.dailycodebuffer.ProductService.model.ErrorResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice

public class RestResponceEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponce> handleProductServiceException(ProductServiceCustomException exception) {
        return new  ResponseEntity<>(new ErrorResponce().builder()
                .errorMessage(exception.getMessage())
                 .errorCode(exception.getErrorCode())
                 .build(), HttpStatus.NOT_FOUND);
    }
}
