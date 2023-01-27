package com.example.bookingnl.converter;

import com.example.bookingnl.controller.CreateUserRequest;
import com.example.bookingnl.controller.UpdateUserRequest;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.controller.UserResponse;
import org.hibernate.sql.Update;


public class UserConverter {


    public static User requestToEntity(CreateUserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .adress(request.getAdress())
                .role(request.getRole())
                .build();
        return user;
    }

    public static UserResponse entityToResponse(User user) {
        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .adress(user.getAdress())
                .build();
        return response;
    }

    public static User updateRequestToUser(User user, UpdateUserRequest request) {
                user.setFirstName(request.getFirstName());
                user.setLastName(request.getLastName());
                user.setAdress(request.getAdress());
        return user;
    }
}
