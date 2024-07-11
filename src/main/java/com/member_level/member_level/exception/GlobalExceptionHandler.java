package com.member_level.member_level.exception;

import com.member_level.member_level.constants.AppConstant;
import com.member_level.member_level.util.ApiResponseUtil;
import com.member_level.member_level.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;

import static com.member_level.member_level.constants.AppConstant.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return buildRunErrorResponse(ex, request);
    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException ex, WebRequest request) {
        logger.error(NOT_FOUND, ex);
        return buildErrorResponse(ex, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.error(Helper.convertMapWithIteration(errors), ex);

        return buildErrorValidateResponse(ex, errors, request);
    }

    private ResponseEntity<Object> buildErrorValidateResponse(Exception ex, Map<String, String> errors, WebRequest request) {
        return buildErrorResponse(ex, Helper.convertMapWithIteration(errors), HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception ex, String message, @NonNull HttpStatusCode statusCode, WebRequest request) {
        return ResponseEntity.status(statusCode).body(ApiResponseUtil.createApiResponse(null, AppConstant.ERROR_CODE_ONE, AppConstant.RESPONSE_CODE_ZERO,message));
    }

    private ResponseEntity<Object> buildErrorResponse(Exception ex, WebRequest request) {
        return buildErrorResponse(ex, ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    private ResponseEntity<Object> buildRunErrorResponse(Exception ex, WebRequest request) {
        return buildErrorResponse(ex, ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }
}