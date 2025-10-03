package xyz.sm10.blogs.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.CategoryDto;

import java.util.List;


public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto category);
    //update
    CategoryDto updateCategory(CategoryDto category, Integer categoryId);
    CategoryDto updatePartialCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);


    //get All
    List<CategoryDto> getAllCategories();
}
