package xyz.sm10.blogs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.sm10.blogs.entities.Category;
import xyz.sm10.blogs.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    @NotBlank
    private String title;
    private String content;
    private User authorId;
    private Category categoryId;
    private Boolean isPublished;
}
