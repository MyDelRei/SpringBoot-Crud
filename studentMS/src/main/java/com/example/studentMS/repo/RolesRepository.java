package com.example.studentMS.repo;

import com.example.studentMS.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, String> {
    Roles findByRoleName(String roleName);
}