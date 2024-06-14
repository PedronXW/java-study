package com.study.auth.auth.domain.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.auth.auth.domain.application.errors.UserAlreadyExistsError;
import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;
import com.study.auth.auth.domain.enterprise.entities.user.UserProps;

@Service
public class CreateUserService {

    @Autowired
    public UserRepository userRepository;

    public User execute(String name, String email, String password, String role) {

        final User userExists = userRepository.findByEmail(email);

        if (userExists != null) {
            throw new UserAlreadyExistsError();
        }

        final UserProps userProps = new UserProps(name, email, password, role, true, null, null, null);

        final User user = new User(userProps);

        userRepository.create(user);

        return user;

    }
    
}
