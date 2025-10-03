package xyz.sm10.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private boolean success;
    private Integer status;
    private String message;
    private String path;
    private String resource;
    private String field;
    private Object value;
}
