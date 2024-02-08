package com.myprojects.financecontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.services.excepetions.ForbiddenExcepetion;


@Service
public class AuthService {
    @Autowired
    private UserService userService;
    
    public void validateSelfOrAdmin (Long userId){
        User user = userService.authenticated();
        if (!user.hasRole("ROLE_ADMIN") && !user.getId().equals(userId))
            throw new ForbiddenExcepetion("Access deined");
    }
}
