package com.myprojects.financecontrol.DTO;

import java.util.HashSet;
import java.util.Set;

import com.myprojects.financecontrol.entities.Category;
import com.myprojects.financecontrol.entities.Expense;
import com.myprojects.financecontrol.entities.User;

public class UserDTO {
    
    private Long id;
    private String email;
    private String name;
    private Set<CategoryDTO> categories = new HashSet<>();
    private Set<ExpenseDTO> expenses = new HashSet<>();

    public UserDTO(){

    }

    public UserDTO(Long id, String email, String name, Set<CategoryDTO> categories, Set<ExpenseDTO> expenses) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.categories = categories;
        this.expenses = expenses;
    }

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
        name = user.getName();
        for(Category cat: user.getCategories()){
            CategoryDTO dto = new CategoryDTO(cat.getId(), cat.getName());
            categories.add(dto);
        }
        for(Expense exp: user.getExpenses()){
            ExpenseDTO dto = new ExpenseDTO(exp.getId(), exp.getAmmount(), exp.getCategory().getName(), exp.getDate());
            expenses.add(dto);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public Set<ExpenseDTO> getExpenses() {
        return expenses;
    }

}
