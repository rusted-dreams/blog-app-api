package xyz.sm10.blogs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.sm10.blogs.dto.CategoryDto;
import xyz.sm10.blogs.services.impl.CategoryServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto category) {
        try{
            CategoryDto newCategory = categoryService.createCategory(category);
            return new ResponseEntity<>(newCategory, HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(400));
        }
    }
}
