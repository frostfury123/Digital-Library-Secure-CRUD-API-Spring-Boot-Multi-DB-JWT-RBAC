package com.example.CRUD_API_Book_Resource.service;

import com.example.CRUD_API_Book_Resource.model.postgres.AuditLog;
import com.example.CRUD_API_Book_Resource.model.postgres.Users;
import com.example.CRUD_API_Book_Resource.repository.postgres.AuditLogRepository;
import com.example.CRUD_API_Book_Resource.repository.postgres.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

            @Autowired
            private AuditLogRepository auditRepo;

            @Autowired
            private UserRepository userRepo;

            /**
             * Logs an action performed by the currently authenticated principal.
             * Attempts to resolve principal to Users.id; if not found, stores user_id = null.
            */

            public void logCurrentUser(String action, Long bookId){

                    Integer userId = resolveCurrentUserId();
                    auditRepo.save(new AuditLog(userId, action, bookId));
            }

            /**
             * Logs an action on behalf of a specific user id (e.g., system actions).
             */

            public void log(Integer userId, String action, Long bookId){

                    auditRepo.save(new AuditLog(userId, action, bookId));

            }

            private Integer resolveCurrentUserId(){

                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                if(auth == null){
                    return null;
                }
                String username = auth.getName();
                if(username == null){
                    return null;
                }
                Users u = userRepo.findByUsername(username);
                return (u != null) ? u.getId() : null;
            }
}
