package com.example.applicationsystemservice.service;

import com.example.applicationsystemservice.domain.dto.ProjectDto;
import com.example.applicationsystemservice.domain.entity.RoleEntity;

import java.util.Optional;

public interface RoleService {
//    RoleEntity createRole(RoleEntity roleEntity);
    Optional<RoleEntity> findById(Long id);

    RoleEntity findByName(String name);
}
