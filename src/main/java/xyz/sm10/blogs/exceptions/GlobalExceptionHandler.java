package xyz.sm10.blogs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import xyz.sm10.blogs.dto.ErrorDetailsDto;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetailsDto err = new ErrorDetailsDto(
                false,
                ex.getMessage(),
                request.getDescription(false),
                ex.getResource(),
                ex.getField(),
                ex.getValue(),
                LocalDateTime.now()
                );
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // handle all other exceptions (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handleAllExceptions(Exception ex, WebRequest request){
        ErrorDetailsDto err = new ErrorDetailsDto(
                false,
                ex.getMessage(),
                request.getDescription(false),
                null,
                null,
                null,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
