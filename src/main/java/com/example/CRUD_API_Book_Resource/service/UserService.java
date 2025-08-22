package com.example.CRUD_API_Book_Resource.service;

import com.example.CRUD_API_Book_Resource.model.postgres.Users;
import com.example.CRUD_API_Book_Resource.repository.postgres.UserRepository;
import com.example.CRUD_API_Book_Resource.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Users register(Users user){

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Role.READER);
            return repo.save(user);
    }

    public Users admin_register(Users user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user){
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if(authentication.isAuthenticated()){
                return jwtService.generateToken(user.getUsername());
            }
            return "Fail";
    }

}
