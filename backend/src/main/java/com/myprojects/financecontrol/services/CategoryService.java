package com.myprojects.financecontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.financecontrol.DTO.CategoryDTO;
import com.myprojects.financecontrol.entities.Category;
import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.repositories.CategoryRepository;
import com.myprojects.financecontrol.services.excepetions.DatabaseException;
import com.myprojects.financecontrol.services.excepetions.ForbiddenExcepetion;
import com.myprojects.financecontrol.services.excepetions.ResourceNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;
    
    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(String name, Pageable pageable){
        User user = userService.authenticated();
        Page<Category> result = categoryRepository.searchCategoriesByUserId(user.getId(), name, pageable);
        return result.map(cat -> new CategoryDTO(cat));
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        copyDtoToEntity(dto, entity);
        User user = userService.authenticated();
        entity.setUserId(user);
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long categoryId, CategoryDTO dto) {
        
        if(!categoryRepository.existsById(categoryId))
            throw new ResourceNotFoundException("Resource not found: " + categoryId);

        User user = userService.authenticated();
        System.out.println("user id:" + user.getId());

        if(!validateIfCategoryBelongsToUser(categoryId, user.getId()))
            throw new ForbiddenExcepetion("Category " + categoryId);
            
        Category category = categoryRepository.findCategoryById(categoryId);
        copyDtoToEntity(dto, category);
        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    private void copyDtoToEntity(CategoryDTO dto, Category entity) {
        entity.setName(dto.getName());
    }

    private boolean validateIfCategoryBelongsToUser(Long categoryId, Long userId) {
        List<Long> categories = categoryRepository.findCategoriesIdByUserId(userId);
        System.out.println("List of categories id:"+ categories);
        if(categories.contains(categoryId))
            return true;
        
        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Resource not found: " + id);

        User user = userService.authenticated();
        if(!validateIfCategoryBelongsToUser(id, user.getId()))
            throw new ForbiddenExcepetion("Category: " + id);

        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation");
        }
        
    }
}
