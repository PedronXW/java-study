package com.study.auth.auth.infra.http.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.auth.auth.domain.application.services.user.DeleteUserService;

@RestController
public class DeleteUserController {
    
    @Autowired
    public DeleteUserService deleteUserService;

    @DeleteMapping()
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {

        deleteUserService.execute(email);
    
        return ResponseEntity.noContent().build();

    }

}
