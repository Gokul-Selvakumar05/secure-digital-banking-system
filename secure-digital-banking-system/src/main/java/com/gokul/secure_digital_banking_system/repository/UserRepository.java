package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String UserName);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);

}
