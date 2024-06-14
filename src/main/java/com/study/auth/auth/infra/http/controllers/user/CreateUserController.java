package com.study.auth.auth.infra.http.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.auth.auth.domain.application.mappers.UserMapped;
import com.study.auth.auth.domain.application.services.user.CreateUserService;
import com.study.auth.auth.infra.http.dto.CreateUserDTO;

@CrossOrigin
@RestController
public class CreateUserController {

    @Autowired
    public CreateUserService createUserService;

    @PostMapping()
    public ResponseEntity<UserMapped> createUser(@RequestBody CreateUserDTO createUserDTO) {
    
        return  ResponseEntity.ok(new UserMapped(createUserService.execute(createUserDTO.name, createUserDTO.email, createUserDTO.password, createUserDTO.role)));
    }
    
}


    

    

