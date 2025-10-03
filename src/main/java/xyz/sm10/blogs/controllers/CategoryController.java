package xyz.sm10.blogs.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.sm10.blogs.dto.CategoryDto;
import xyz.sm10.blogs.services.impl.CategoryServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id) {
        CategoryDto category = categoryService.getCategory((id));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto category) {
        CategoryDto newCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer id, @RequestBody CategoryDto category) {
        CategoryDto newCategory = categoryService.updateCategory(category, id);
        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CategoryDto> partialUpdateCategory(@Valid @PathVariable Integer id, @RequestBody CategoryDto category) {
        CategoryDto updated = categoryService.updatePartialCategory(category, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
