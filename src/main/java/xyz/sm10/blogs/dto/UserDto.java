package xyz.sm10.blogs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDto {
    private int id;
    private String name;
    @NotBlank
    @Email
    private String email;

    @Length(min = 8, max = 64)
    private String password;
    private String bio;
}
