package com.study.auth.auth.domain.application.services.user;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.auth.auth.domain.enterprise.entities.user.User;
import com.study.auth.auth.domain.enterprise.entities.user.UserProps;
import com.study.auth.auth.infra.database.repositories.PostgresUserRepository;

@ExtendWith(MockitoExtension.class)
public class CreateUserServiceTest {

    @Mock
    public PostgresUserRepository mockRepository;

    @InjectMocks
    public CreateUserService createUserService;

    @Test
    public void creatingUser(){

        Mockito.when(this.mockRepository.findByEmail(anyString())).thenReturn(null);

        final UserProps userProps = new UserProps(
            "John Doe", 
            "johndoe@john.com",
            "123456",
            "role",
            true,
            null,
            null,
            null
        );

        final User user = createUserService.execute(
            "John Doe",
            "johndoe@john.com",
            "123456",
            "role"
        );

        Mockito.verify(mockRepository, Mockito.times(1)).create(user);

        Assertions.assertEquals("John Doe", user.getName());



    }
    
}
