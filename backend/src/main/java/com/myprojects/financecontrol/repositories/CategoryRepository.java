package com.myprojects.financecontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.financecontrol.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
