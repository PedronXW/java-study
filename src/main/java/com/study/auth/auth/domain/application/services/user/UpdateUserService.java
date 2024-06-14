package com.study.auth.auth.domain.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.auth.auth.domain.application.errors.UserNotFoundError;
import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;

@Service
public class UpdateUserService {
    @Autowired
    public UserRepository userRepository;

    public User execute(String email, String name) {

        final User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundError();
        }

        user.setName(name);

        return userRepository.update(user);


    }
}
