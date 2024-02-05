package com.myprojects.financecontrol.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myprojects.financecontrol.DTO.CategoryDTO;
import com.myprojects.financecontrol.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(
        @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
        Page<CategoryDTO> result = categoryService.findAll(name, pageable);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        dto = categoryService.insert(dto);
        //personalize API response to 201 code
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
        System.out.println("Received ID from path variable: " + id); 
        CategoryDTO updatedCatDto = categoryService.update(id, dto);
        return ResponseEntity.ok(updatedCatDto);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
