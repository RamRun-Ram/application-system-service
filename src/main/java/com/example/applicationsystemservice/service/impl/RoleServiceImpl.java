package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.domain.entity.RoleEntity;
import com.example.applicationsystemservice.service.RoleService;
import com.example.applicationsystemservice.service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @PostConstruct
    public void createRoles(){
        Optional<RoleEntity> optionalRoleEntity = roleRepository.findById(1L);
        if (optionalRoleEntity.isEmpty()){
            roleRepository.save(new RoleEntity(1L,"admin"));
        }
    }
    @Override
    public Optional<RoleEntity> findById(Long id){
       return roleRepository.findById(id);
    }
}
