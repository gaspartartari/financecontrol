package com.myprojects.financecontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.financecontrol.DTO.CategoryDTO;
import com.myprojects.financecontrol.entities.Category;
import com.myprojects.financecontrol.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable){
        
        Page<Category> result = categoryRepository.findAll(pageable);
        return result.map(cat -> new CategoryDTO(cat));
    }
}
