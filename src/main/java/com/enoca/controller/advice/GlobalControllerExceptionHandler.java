package com.enoca.controller.advice;

import com.enoca.exception.CartNotFoundException;
import com.enoca.exception.CustomerNotFoundException;
import com.enoca.exception.OrderNotFoundException;
import com.enoca.exception.ProductNotFoundException;
import com.enoca.exception.StockNotFoundException;
import com.enoca.model.response.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CartNotFoundException exception) {
        return instanceError(exception, "cart-not-found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(ProductNotFoundException exception) {
        return instanceError(exception, "product-not-found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(StockNotFoundException exception) {
        return instanceError(exception, "stock-not-found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CustomerNotFoundException exception) {
        return instanceError(exception, "customer-not-found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(OrderNotFoundException exception) {
        return instanceError(exception, "order-not-found", HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> instanceError(RuntimeException ex, String errorMessage, HttpStatus status) {
        log.error(errorMessage + " exception occurred.", ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .exception(ex.getClass().getSimpleName())
                .errors(Collections.singletonList(ex.getMessage()))
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }
}

