package com.gokul.secure_digital_banking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String  roleName;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public static final String ROLE_USER="ROLE_USER";
    public static final String ROLE_ADMIN="ROLE_ADMIN";


}
