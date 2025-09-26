package xyz.sm10.blogs.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String bio;
}
