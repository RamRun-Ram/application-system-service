package com.example.applicationsystemservice.service;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.entity.RoleEntity;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto);
    void setRole(Long id, RoleEntity role);
    boolean deleteAccount(Long id);
}
