package xyz.sm10.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetailsDto {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String resource;
    private String field;
    private Object value;
}
