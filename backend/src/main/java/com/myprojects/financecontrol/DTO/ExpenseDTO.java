package com.myprojects.financecontrol.DTO;

import java.time.Instant;

import com.myprojects.financecontrol.entities.Expense;

public class ExpenseDTO {
    
    private Long id;
    private Double amount;
    private String category;
    private Instant date;

    public ExpenseDTO(){

    }

    public ExpenseDTO(Long id, Double amount, String category, Instant date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public ExpenseDTO(Expense expense) {
        id = expense.getId();
        amount = expense.getAmmount();
        category = expense.getCategory().getName();
        date = expense.getDate();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Instant getDate() {
        return date;
    }
}
