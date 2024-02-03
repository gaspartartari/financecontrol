package com.myprojects.financecontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.financecontrol.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
