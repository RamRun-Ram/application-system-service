package com.example.applicationsystemservice.controller;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.entity.RoleEntity;
import com.example.applicationsystemservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable Long id){
       return accountService.findAccount(id);
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @PutMapping
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.updateAccount(accountDto);
    }

    @PutMapping("set-role")
    public void setAccountRole(@RequestParam Long id, @RequestBody RoleEntity role) {
        accountService.setRole(id, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

}
