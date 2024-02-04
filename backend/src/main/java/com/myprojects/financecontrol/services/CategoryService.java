package com.myprojects.financecontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.financecontrol.DTO.CategoryDTO;
import com.myprojects.financecontrol.entities.Category;
import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;
    
    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable){
        User user = userService.authenticated();
        Page<Category> result = categoryRepository.searchCategoriesByUserId(user.getId(), pageable);
        return result.map(cat -> new CategoryDTO(cat));
    }
}
