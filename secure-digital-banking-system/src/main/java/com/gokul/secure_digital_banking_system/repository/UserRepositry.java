package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String UserName);
    Optional<User> findByEmail(String email);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
