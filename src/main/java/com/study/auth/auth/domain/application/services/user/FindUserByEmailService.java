package com.study.auth.auth.domain.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.auth.auth.domain.application.errors.UserNotFoundError;
import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;

@Service
public class FindUserByEmailService {

    @Autowired
    private UserRepository userRepository;

    public User execute(String email) {

        final User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundError();
        }

        return user;

    }
    
}
