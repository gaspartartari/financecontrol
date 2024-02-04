package com.myprojects.financecontrol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.projections.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long> {
    

    @Query(nativeQuery = true, 
        value =  "SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority "
                + "FROM tb_user INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id "
                + "INNER JOIN tb_role ON tb_user_role.role_id = tb_role.id "
                + "WHERE tb_user.email = :email ")
    public List<UserDetailsProjection> searchUsersAndRolesByEmail(String email);

    public Optional<User> findByEmail(String username);
}
