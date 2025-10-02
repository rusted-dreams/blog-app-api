package xyz.sm10.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetailsDto {
    private boolean success;
    private String message;
    private String path;
    private String resource;
    private String field;
    private Object value;
    private LocalDateTime timestamp;
}
