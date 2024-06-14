package com.study.auth.auth.infra.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.application.services.user.CreateUserService;
import com.study.auth.auth.domain.application.services.user.DeleteUserService;
import com.study.auth.auth.domain.application.services.user.FindUserByEmailService;
import com.study.auth.auth.domain.application.services.user.FindUserByIdService;
import com.study.auth.auth.domain.application.services.user.UpdateUserService;
import com.study.auth.auth.infra.database.models.UserModel;
import com.study.auth.auth.infra.database.repositories.PostgresUserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class UserBeansConfig {

    @Bean
    public CreateUserService createUserService() {
        return new CreateUserService();
    }

    @Bean
    public FindUserByEmailService findUserByEmailService() {
        return new FindUserByEmailService();
    }

    @Bean
    public FindUserByIdService findUserByIdService() {
        return new FindUserByIdService();
    }

    @Bean
    public UpdateUserService updateUserService() {
        return new UpdateUserService();
    }

    @Bean
    public DeleteUserService deleteUserService() {
        return new DeleteUserService();
    }

    @Bean
    public UserRepository userRepository() {
        return new PostgresUserRepository();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public SimpleJpaRepository userJpaRepository() {
        return new SimpleJpaRepository(UserModel.class, entityManager);
    }
    
    
}
