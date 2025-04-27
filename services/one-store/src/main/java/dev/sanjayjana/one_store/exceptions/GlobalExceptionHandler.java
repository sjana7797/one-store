package dev.sanjayjana.one_store.exceptions;


import dev.sanjayjana.one_store.response.ErrorApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        ErrorApiResponse errorApiResponse = new ErrorApiResponse<>(errors.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApiResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorApiResponse> handleBadRequestExceptions(BadRequestException ex) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApiResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorApiResponse> handleNotFoundExceptions(NotFoundException ex) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorApiResponse);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ErrorApiResponse> handleUnauthorizedExceptions(UnAuthorizedException ex) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorApiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiResponse> handleAllExceptions(Exception ex) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorApiResponse);
    }
}
