package xyz.sm10.blogs.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.CategoryDto;
import xyz.sm10.blogs.entities.Category;
import xyz.sm10.blogs.exceptions.ResourceNotFoundException;
import xyz.sm10.blogs.repositories.CategoryRepo;
import xyz.sm10.blogs.services.CategoryService;

import java.util.List;


@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepo categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        boolean exists = categoryRepo.existsByTitle(category.getTitle());
        if(exists) throw new RuntimeException("Category '" + category.getTitle() + "' already exists");

        Category newCategory = modelMapper.map(category, Category.class);
        Category savedCategory = categoryRepo.save(newCategory);
        return modelMapper.map(savedCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {
        return null;
    }

    @Override
    public void deleteCategory(Integer cid) {
        Category exists = categoryRepo.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", String.valueOf(cid)));
    }

    @Override
    public CategoryDto getCategory(Integer cid) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return List.of();
    }
}
