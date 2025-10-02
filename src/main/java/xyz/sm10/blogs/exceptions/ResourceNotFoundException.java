package xyz.sm10.blogs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String field;
    private Object value;

    @Override
    public String getMessage(){
        return String.format("%s not found with %s : %s", resource, field, String.valueOf(value));
    }

// or you can create the constructor manually like below:

//    ResourceNotFoundException(String resource, String field, String value) {
//        super(String.format("%s not found with %s : %s", resource, field, value));
//        this.resource = resource;
//        this.field = field;
//        this.value = value;
//    }


}
