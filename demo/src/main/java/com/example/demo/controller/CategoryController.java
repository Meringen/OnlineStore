package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @GetMapping("/list")
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{categoryId}")
    public CategoryDto findById(@PathVariable(name = "categoryId") long categoryId){
        return categoryService.findById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public CategoryDto update(@RequestBody CategoryDto categoryDto, @PathVariable(name = "categoryId") long categoryId){
        return categoryService.update(categoryDto, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable(name = "categoryId") long categoryId){
        categoryService.delete(categoryId);
    }
}