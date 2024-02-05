package com.myprojects.financecontrol.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.financecontrol.DTO.ExpenseDTO;
import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired UserService userService;

   
    @Transactional(readOnly = true)
    public Page<ExpenseDTO> getAllExepnses(Instant minDate, Instant maxDate, String categoryName, Pageable pageable) {
        User user = userService.authenticated();
        return expenseRepository.getAllExpenses(user.getId(), minDate, maxDate, categoryName, pageable);

    }
    
    
}
