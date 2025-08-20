package com.example.CRUD_API_Book_Resource.repository.postgres;

import com.example.CRUD_API_Book_Resource.model.postgres.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
