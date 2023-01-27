package com.example.bookingnl.persistence;

import com.example.bookingnl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findUserByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);

    User findUserById(Long id);
}
