package com.myprojects.financecontrol.repositories;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myprojects.financecontrol.DTO.ExpenseDTO;
import com.myprojects.financecontrol.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query(value = "SELECT new com.myprojects.financecontrol.DTO.ExpenseDTO(e.id, e.amount, c.name, e.date) " +
        "FROM Expense e " +
        "JOIN e.userId u " +
        "JOIN e.category c " +
        "WHERE u.id = :userId " +
        "AND (:categoryName IS NULL OR UPPER(c.name) LIKE UPPER(CONCAT('%', :categoryName, '%'))) " +
        "AND (:minDate IS NULL OR e.date >= :minDate) " +
        "AND (:maxDate IS NULL OR e.date <= :maxDate)",
    countQuery = "SELECT count(e) " +
        "FROM Expense e " +
        "JOIN e.userId u " +
        "JOIN e.category c " +
        "WHERE u.id = :userId " +
        "AND (:categoryName IS NULL OR UPPER(c.name) LIKE UPPER(CONCAT('%', :categoryName, '%'))) " +
        "AND (:minDate IS NULL OR e.date >= :minDate) " +
        "AND (:maxDate IS NULL OR e.date <= :maxDate)")
    Page<ExpenseDTO> getAllExpenses(Long userId, Instant minDate, Instant maxDate, String categoryName, Pageable pageable);




}

