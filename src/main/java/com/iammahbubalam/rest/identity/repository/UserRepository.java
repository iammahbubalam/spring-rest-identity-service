package com.iammahbubalam.rest.identity.repository;
import java.util.Optional;
import java.util.UUID;
import com.iammahbubalam.rest.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    // Custom query methods can be defined here if needed
    // For example:
    // Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    String findPasswordHashByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}