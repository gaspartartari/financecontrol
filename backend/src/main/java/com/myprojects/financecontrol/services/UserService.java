package com.myprojects.financecontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myprojects.financecontrol.entities.Role;
import com.myprojects.financecontrol.entities.User;
import com.myprojects.financecontrol.projections.UserDetailsProjection;
import com.myprojects.financecontrol.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = userRepository.searchUsersAndRolesByEmail(username);
        
        if(result.size() == 0)
            throw new UsernameNotFoundException("username not found");
        
        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for(UserDetailsProjection projection : result){
            Role role = new Role(projection.getRoleId(), projection.getAuthority());
            user.addRole(role);
        }
        return user;
    }
}
