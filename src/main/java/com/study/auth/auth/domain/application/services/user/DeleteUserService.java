package com.study.auth.auth.domain.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.auth.auth.domain.application.errors.UserNotFoundError;
import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;

@Service
public class DeleteUserService {
    @Autowired
    public UserRepository userRepository;

    public void execute(String email) {

        final User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundError();
        }

        user.setActive(false);

        userRepository.delete(user);

    }
}
