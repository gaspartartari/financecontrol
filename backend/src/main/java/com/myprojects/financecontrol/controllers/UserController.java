package com.myprojects.financecontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.financecontrol.DTO.UserMinDTO;
import com.myprojects.financecontrol.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserMinDTO> getMe(){
        UserMinDTO dto = userService.getMe();
        return ResponseEntity.ok(dto);
    }
}
