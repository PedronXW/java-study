package com.study.auth.auth.infra.http.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.auth.auth.domain.application.mappers.UserMapped;
import com.study.auth.auth.domain.application.services.user.FindUserByIdService;


@RestController
public class FindUserByIdController {

    @Autowired
    public FindUserByIdService findUserByIdService;

    
    @GetMapping("/{id}")
    public ResponseEntity<UserMapped> findUserByIdController(@PathVariable(value = "id") String id) {

        return ResponseEntity.ok(new UserMapped(findUserByIdService.execute(id)));

    }


    
}
