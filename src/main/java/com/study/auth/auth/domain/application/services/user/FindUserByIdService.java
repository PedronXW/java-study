package com.study.auth.auth.domain.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.auth.auth.domain.application.errors.UserNotFoundError;
import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;

@Service
public class FindUserByIdService {

    @Autowired
    private UserRepository userRepository;

    public User execute(String id) {

        final User user = userRepository.findById(id);

        if (user == null) {
            throw new UserNotFoundError();
        }

        return user;

    }
    
}
