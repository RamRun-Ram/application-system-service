package com.example.applicationsystemservice.controller;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @PutMapping
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.updateAccount(accountDto);
    }

//    @PutMapping
//    public void setAccountRole(@RequestBody Long id, @RequestBody RoleEntity role) {
//        accountService.setRole(id, role);
//    }

    @DeleteMapping("/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

}
