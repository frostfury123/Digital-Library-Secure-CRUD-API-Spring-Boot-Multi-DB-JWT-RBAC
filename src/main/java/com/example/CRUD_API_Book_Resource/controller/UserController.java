package com.example.CRUD_API_Book_Resource.controller;

import com.example.CRUD_API_Book_Resource.model.postgres.Users;
import com.example.CRUD_API_Book_Resource.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService service;

        @PostMapping("/register")
        public Users register(@RequestBody Users user){
            return service.register(user);
        }

        @PostMapping("/login")
        public String login(@RequestBody Users user){
            return service.verify(user);
        }

        @PostMapping("/auth/login")
        public ResponseEntity<?> authLogin(@RequestBody Users user){
            String token = service.verify(user);
            if("Fail".equals(token)){
                return ResponseEntity.status(401).body(Map.of("error", "Invalid Credentials"));
            }

            return ResponseEntity.ok(Map.of("access_token", token, "expires_in", 1800));
        }


        @GetMapping("/login/google")
        public void loginWithGoogle(HttpServletResponse response) throws IOException{
            response.sendRedirect("/oauth2/authorization/google");
        }

        @GetMapping("/login/github")
        public void loginWithGitHub(HttpServletResponse response) throws IOException{
            response.sendRedirect("/oauth2/authorization/github");
        }

}
