package com.study.auth.auth.domain.application.mappers;

import java.time.LocalDateTime;

import com.study.auth.auth.domain.enterprise.entities.user.User;

public class UserMapped {

    public String id;
    public String name;
    public String email;
    public String role;
    public Boolean active;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;

    public UserMapped(User user){
        this.id = user.getId().getValue();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.active = user.getActive();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deletedAt = user.getDeletedAt();
    }
    
}
