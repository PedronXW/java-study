package com.study.auth.auth.domain.enterprise.entities.user;

import java.time.LocalDateTime;

import com.study.auth.auth.shared.Entity;
import com.study.auth.auth.shared.EntityId;

public class User extends Entity<UserProps>{
    public User(EntityId id, UserProps props) {
        super(id, props);
    }

    public User(UserProps props) {
        super(props);
    }

    public String getName(){
        return this.props.name;
    }

    public String getEmail(){
        return this.props.email;
    }

    public String getPassword(){
        return this.props.password;
    }

    public String getRole(){
        return this.props.role;
    }

    public Boolean getActive(){
        return this.props.active;
    }

    public LocalDateTime getCreatedAt(){
        return this.props.createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return this.props.updatedAt;
    }

    public LocalDateTime getDeletedAt(){
        return this.props.deletedAt;
    }

    public void setName(String name){
        this.props.name = name;
    }

    public void setEmail(String email){
        this.props.email = email;
    }

    public void setPassword(String password){
        this.props.password = password;
    }

    public void setRole(String role){
        this.props.role = role;
    }

    public void setActive(Boolean active){
        this.props.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.props.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt){
        this.props.updatedAt = updatedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt){
        this.props.deletedAt = deletedAt;
    }
    
}
