package xyz.sm10.blogs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
public class CategoryDto {
    private Integer cid;
    @NotBlank
    private String Title;
    private String Description;
}
