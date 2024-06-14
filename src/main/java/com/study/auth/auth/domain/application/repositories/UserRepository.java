package com.study.auth.auth.domain.application.repositories;

import com.study.auth.auth.domain.enterprise.entities.user.User;

public interface UserRepository{
    public abstract void create(User user);
    public abstract User findByEmail(String email);
    public abstract User findById(String id);
    public abstract User update(User user);
    public abstract void delete(User user);
}
