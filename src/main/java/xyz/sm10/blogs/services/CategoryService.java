package xyz.sm10.blogs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.CategoryDto;

import java.util.List;


public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto category);
    //update
    CategoryDto updateCategory(CategoryDto category);

    //delete
    void deleteCategory(Integer cid);

    //get
    CategoryDto getCategory(Integer cid);

    //get All
    List<CategoryDto> getAllCategories();
}
