package com.myprojects.financecontrol.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myprojects.financecontrol.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    @Query(value = 
        "SELECT cat FROM User usr JOIN usr.categories cat WHERE usr.id = :id "
        + "AND UPPER(cat.name) LIKE UPPER(CONCAT('%', :name, '%'))",
        countQuery = "SELECT count(cat) FROM User usr JOIN usr.categories cat WHERE usr.id = :id "
        + "AND UPPER(cat.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Category> searchCategoriesByUserId(Long id, String name, Pageable pageable);

}
