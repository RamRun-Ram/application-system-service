package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.entity.RoleEntity;
import com.example.applicationsystemservice.service.RoleService;
import com.example.applicationsystemservice.service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @PostConstruct
    public void createRoles(){
        RoleEntity adminRole = roleRepository.findByRoleName("admin");
        //?
        if (adminRole == null){
            roleRepository.save(new RoleEntity(1L,"admin"));
        }

        RoleEntity devRole = roleRepository.findByRoleName("developer");
        if (devRole == null){
            roleRepository.save(new RoleEntity(2L,"developer"));
        }
    }
    @Override
    public Optional<RoleEntity> findById(Long id){
       return roleRepository.findById(id);
    }

    @Override
    public RoleEntity findByName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
