package com.study.auth.auth.domain.enterprise.entities.user;

import java.time.LocalDateTime;

public class UserProps{
    public String name;
    public String email;
    public String password;
    public String role;
    public Boolean active;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;

    public UserProps(String name, String email, String password, String role, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
