package com.example.CRUD_API_Book_Resource.security;

import java.util.Set;

import static com.example.CRUD_API_Book_Resource.security.Permission.*;

public enum Role {
    READER(Set.of(VIEW_BOOKS)),
    EDITOR(Set.of(VIEW_BOOKS, CREATE_BOOKS, UPDATE_BOOKS)),
    LIBRARIAN(Set.of(VIEW_BOOKS, CREATE_BOOKS, UPDATE_BOOKS, DELETE_BOOKS)),
    ADMINISTRATOR(Set.of(VIEW_BOOKS, CREATE_BOOKS, UPDATE_BOOKS, DELETE_BOOKS, MANAGE_USERS));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {     // getter method
        return permissions;
    }
}
