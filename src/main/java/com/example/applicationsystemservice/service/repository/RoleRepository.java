package com.example.applicationsystemservice.service.repository;

import com.example.applicationsystemservice.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByRoleName(String roleName);
}
