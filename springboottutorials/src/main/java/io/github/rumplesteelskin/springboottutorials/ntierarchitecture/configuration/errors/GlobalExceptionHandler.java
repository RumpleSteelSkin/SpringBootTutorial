package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.configuration.errors;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.configuration.errors.custom.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(NotFoundException ex) {
        logger.warn("NotFoundException caught: {}", ex.getMessage());

        ApiErrorResponse.ErrorDetail detail = new ApiErrorResponse.ErrorDetail(
                "resource",
                "NOT_FOUND",
                ex.getMessage(),
                null,
                null
        );

        ApiErrorResponse.ErrorBody errorBody = new ApiErrorResponse.ErrorBody(
                List.of(detail),
                HttpStatus.NOT_FOUND.value(),
                "The requested resource was not found."
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(errorBody));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {

        logger.error("An unexpected error occurred. ", ex);

        ApiErrorResponse.ErrorDetail detail = new ApiErrorResponse.ErrorDetail(
                "global",
                "INTERNAL_ERROR",
                "An unexpected error occurred. Please try again later.",
                null,
                null
        );

        ApiErrorResponse.ErrorBody errorBody = new ApiErrorResponse.ErrorBody(
                List.of(detail),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Server experienced an internal error."
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(errorBody));
    }
}