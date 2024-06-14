package com.study.auth.auth.infra.database.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.auth.auth.domain.application.repositories.UserRepository;
import com.study.auth.auth.domain.enterprise.entities.user.User;
import com.study.auth.auth.domain.enterprise.entities.user.UserProps;
import com.study.auth.auth.infra.database.mappers.UserMapper;
import com.study.auth.auth.infra.database.models.UserModel;
import com.study.auth.auth.shared.EntityId;

@Repository
public class PostgresUserRepository implements UserRepository {

    @Autowired
    private JpaRepository<UserModel, String> userJpaRepository;

    @Override
    public void create(User user) {
        final UserModel userModel = new UserMapper().toModel(user);
    
        userJpaRepository.save(userModel);
    }

    @Override
    public User findByEmail(String email) {
        UserModel newModel = new UserModel();
        newModel.setEmail(email);
        Example<UserModel> example = Example.of(newModel);
        final Optional<UserModel> userModel = userJpaRepository.findOne(example);

        if (userModel.isEmpty()) {
            return null;
        }

        final UserProps userProps = new UserProps(userModel.get().getName(), userModel.get().getEmail(), userModel.get().getPassword(), userModel.get().getRole(), userModel.get().getActive(), userModel.get().getCreatedAt(), userModel.get().getUpdatedAt(), userModel.get().getDeletedAt()); 
        final User user = new User(new EntityId(userModel.get().getId()), userProps);
        return user;
    }

    @Override
    public User findById(String id) {
        final Optional<UserModel> userModel = userJpaRepository.findById(id);

        if (userModel.isEmpty()) {
            return null;
        }

        final UserProps userProps = new UserProps(userModel.get().getName(), userModel.get().getEmail(), userModel.get().getPassword(), userModel.get().getRole(), userModel.get().getActive(), userModel.get().getCreatedAt(), userModel.get().getUpdatedAt(), userModel.get().getDeletedAt()); 
        final User user = new User(new EntityId(userModel.get().getId()), userProps);
        return user;
    }


    @Override
    public User update(User user) {
        UserModel userModel = new UserMapper().toModel(user);
        userJpaRepository.save(userModel);
        return user;
    }

    @Override
    public void delete(User user) {
        UserModel userModel = new UserMapper().toModel(user);
        userJpaRepository.save(userModel);
    }
    
}
