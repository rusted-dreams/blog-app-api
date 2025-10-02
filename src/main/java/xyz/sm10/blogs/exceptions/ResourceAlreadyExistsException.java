package xyz.sm10.blogs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException{
    private final String resource;
    private final String field;
    private final String value;

    @Override
    public String getMessage() {
        return String.format("%s with %s : %s already exist", resource, field, value);
    }
}
