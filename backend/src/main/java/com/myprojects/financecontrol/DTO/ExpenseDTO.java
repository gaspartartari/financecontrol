package com.myprojects.financecontrol.DTO;

import com.myprojects.financecontrol.entities.Expense;

public class ExpenseDTO {
    
    private Long id;
    private Double amount;
    private String categoryName;

    public ExpenseDTO(){

    }

    public ExpenseDTO(Long id, Double amount, String categoryName) {
        this.id = id;
        this.amount = amount;
        this.categoryName = categoryName;
    }

    public ExpenseDTO(Expense expense) {
        id = expense.getId();
        amount = expense.getAmmount();
        categoryName = expense.getCategory().getName();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    

}
