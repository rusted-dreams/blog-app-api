package xyz.sm10.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String bio;
}
