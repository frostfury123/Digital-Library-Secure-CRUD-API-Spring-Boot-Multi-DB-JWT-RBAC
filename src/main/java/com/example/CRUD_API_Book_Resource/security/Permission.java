package com.example.CRUD_API_Book_Resource.security;

public enum Permission {
    VIEW_BOOKS("view_books"),
    CREATE_BOOKS("create_books"),
    UPDATE_BOOKS("update_books"),
    DELETE_BOOKS("delete_books"),
    MANAGE_USERS("manage_users");

    private final String value;

    Permission(String value) {
        this.value = value;
    }

    public String getValue() {          // getter method
        return value;
    }
}