package com.study.auth.auth.infra.http.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.auth.auth.domain.application.mappers.UserMapped;
import com.study.auth.auth.domain.application.services.user.UpdateUserService;
import com.study.auth.auth.infra.http.dto.UpdateUserDTO;

@RestController
public class UpdateUserController {

    @Autowired
    public UpdateUserService updateUserService;

    @PutMapping()
    public ResponseEntity<UserMapped> updateUser(@RequestParam String email, @RequestBody UpdateUserDTO updateUserDTO) {
    
        return ResponseEntity.ok(new UserMapped(updateUserService.execute(email, updateUserDTO.name)));

    }
    
}
