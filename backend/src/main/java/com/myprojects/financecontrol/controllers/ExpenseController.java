package com.myprojects.financecontrol.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.financecontrol.DTO.ExpenseDTO;
import com.myprojects.financecontrol.services.ExpenseService;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    
    
    @GetMapping
    public ResponseEntity<Page<ExpenseDTO>> getAllExepnses(
        @RequestParam(name = "min", defaultValue = "") String minDateString, 
        @RequestParam(name = "max", defaultValue = "") String maxDateString,
        @RequestParam(name = "categoryName", defaultValue = "") String categoryName,
        Pageable pageable) {
        
        Instant minDateInstant = null;
        Instant maxDateInstant = null;

        if (!minDateString.isEmpty()) {
            minDateInstant = LocalDate.parse(minDateString).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        }

        if (!maxDateString.isEmpty()) {
            maxDateInstant = LocalDate.parse(maxDateString).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant();
        }

        Page<ExpenseDTO> result = expenseService.getAllExepnses(minDateInstant, maxDateInstant, categoryName, pageable);
        return ResponseEntity.ok(result);
    }
}
