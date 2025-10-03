package xyz.sm10.blogs.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.CategoryDto;
import xyz.sm10.blogs.entities.Category;
import xyz.sm10.blogs.exceptions.ResourceAlreadyExistsException;
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
        if(exists) throw new ResourceAlreadyExistsException("category", "title", category.getTitle());

        Category newCategory = modelMapper.map(category, Category.class);
        Category savedCategory = categoryRepo.save(newCategory);
        return modelMapper.map(savedCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto newCategory, Integer cid) {
        Category old = categoryRepo.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", cid));

        modelMapper.map(newCategory, old);
        old.setCategoryId(cid);
        categoryRepo.save(old);

        return modelMapper.map(old, CategoryDto.class);
    }

    @Override
    public CategoryDto updatePartialCategory(CategoryDto category, Integer cid) {
        Category old = categoryRepo.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", cid));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(category, old);
        categoryRepo.save(old);

        return modelMapper.map(old, CategoryDto.class);
    }


    @Override
    public void deleteCategory(Integer cid) {
        Category exists = categoryRepo.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", String.valueOf(cid)));
        categoryRepo.deleteById(cid);
    }

    @Override
    public CategoryDto getCategory(Integer cid) {
        Category category = categoryRepo.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", cid));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepo.findAll()
                .stream()
                .map((category) -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }
}
