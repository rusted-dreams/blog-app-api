package xyz.sm10.blogs.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {
    private Integer cid;
    private String Title;
    private String Description;
}
