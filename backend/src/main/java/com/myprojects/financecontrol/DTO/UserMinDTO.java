package com.myprojects.financecontrol.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import com.myprojects.financecontrol.entities.User;

public class UserMinDTO {
    
    private Long id;
    private String name;
    private String email;
    private List<String> authorities = new ArrayList<>();
    
    public UserMinDTO(){

    }

    public UserMinDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserMinDTO(User entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        for(GrantedAuthority aut : entity.getAuthorities()){
            authorities.add(aut.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getAuthorities() {
        return authorities;
    }
}
