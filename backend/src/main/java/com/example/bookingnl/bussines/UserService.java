package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.User;


public interface UserService {
    User findByEmail(String email);
    User findById(Long id);

    User save(User user);

}
