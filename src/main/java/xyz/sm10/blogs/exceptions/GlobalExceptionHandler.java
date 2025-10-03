package xyz.sm10.blogs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import xyz.sm10.blogs.dto.ErrorResponseDto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponseDto err = new ErrorResponseDto(
                false,
                404,
                ex.getMessage(),
                request.getDescription(false),
                ex.getResource(),
                ex.getField(),
                ex.getValue(),
                LocalDateTime.now()
                );
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // failed validation error:
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach((err) -> {
                    String fieldName = ((FieldError) err).getField();
                    String msg = err.getDefaultMessage();

                    errors.put(fieldName, msg);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // handle all other exceptions (fallback)
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception ex, WebRequest request){
//        ErrorResponseDto err = new ErrorResponseDto(
//                false,
////                500,
//                ex.getMessage(),
//                request.getDescription(false),
//                null,
//                null,
//                null,
//                LocalDateTime.now()
//        );
//        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
