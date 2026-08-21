package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(String rolename);

    boolean existsByName(String name);
}
