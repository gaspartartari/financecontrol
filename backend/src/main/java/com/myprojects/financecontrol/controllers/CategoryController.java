package com.myprojects.financecontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.financecontrol.DTO.CategoryDTO;
import com.myprojects.financecontrol.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable){
        Page<CategoryDTO> result = categoryService.findAll(pageable);
        return ResponseEntity.ok(result);
    }
}
