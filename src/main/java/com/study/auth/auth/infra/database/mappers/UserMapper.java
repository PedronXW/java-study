package com.study.auth.auth.infra.database.mappers;

import com.study.auth.auth.domain.enterprise.entities.user.User;
import com.study.auth.auth.domain.enterprise.entities.user.UserProps;
import com.study.auth.auth.infra.database.models.UserModel;
import com.study.auth.auth.shared.EntityId;

public class UserMapper {

    public static UserModel toModel(User user) {
        final UserModel userModel = new UserModel();
        userModel.setId(user.getId().getValue());
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setRole(user.getRole());
        userModel.setActive(user.getActive());
        userModel.setCreatedAt(user.getCreatedAt());
        userModel.setUpdatedAt(user.getUpdatedAt());
        userModel.setDeletedAt(user.getDeletedAt());
    
        return userModel;
    }

    public static User toDomain(UserModel userModel) {

        final UserProps userProps = new UserProps(userModel.getName(), userModel.getEmail(), userModel.getPassword(), userModel.getRole(), userModel.getActive(), userModel.getCreatedAt(), userModel.getUpdatedAt(), userModel.getDeletedAt());

        final User user = new User(new EntityId(userModel.getId()) ,userProps);
    
        return user;
    }
    
}
