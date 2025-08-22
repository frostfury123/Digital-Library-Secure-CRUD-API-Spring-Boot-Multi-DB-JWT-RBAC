package com.example.CRUD_API_Book_Resource.controller;

import com.example.CRUD_API_Book_Resource.model.postgres.Users;
import com.example.CRUD_API_Book_Resource.security.Role;
import com.example.CRUD_API_Book_Resource.service.AuditLogService;
import com.example.CRUD_API_Book_Resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditLogService auditLogService;

    @PreAuthorize("hasAuthority('manage_users')")
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody CreateUserRequest req) {
        Users u = new Users();
        u.setUsername(req.username());
        u.setPassword(req.password()); // will be encoded in service
        u.setRole(Role.valueOf(req.role())); // "READER|EDITOR|LIBRARIAN|ADMINISTRATOR"
        Users created = userService.admin_register(u);
        // Log the admin's action. book_id = null for user mgmt.
        auditLogService.logCurrentUser("CREATE_USER", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    public record CreateUserRequest(String username, String password, String role)
    {

    }

}



