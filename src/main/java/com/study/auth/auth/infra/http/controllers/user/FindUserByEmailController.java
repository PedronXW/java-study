package com.study.auth.auth.infra.http.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.auth.auth.domain.application.mappers.UserMapped;
import com.study.auth.auth.domain.application.services.user.FindUserByEmailService;

@RestController
public class FindUserByEmailController {

    @Autowired
    public FindUserByEmailService findUserByEmailService;

    @GetMapping()
    public ResponseEntity<UserMapped> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok( new UserMapped(findUserByEmailService.execute(email)));
    }
    
    
}
