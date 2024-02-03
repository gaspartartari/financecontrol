package com.myprojects.financecontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.financecontrol.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}

