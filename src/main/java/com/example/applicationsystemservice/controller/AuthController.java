package com.example.applicationsystemservice.controller;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.mapper.AccountMapper;
import com.example.applicationsystemservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AccountService accountService;
    private AccountMapper accountMapper;


    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping(path = "/login", produces =
            MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AccountEntity
    getAuthUser() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        Object principal = auth.getPrincipal();

        AccountEntity accountEntity = (principal instanceof AccountEntity) ? (AccountEntity)
                principal : null;

        return Objects.nonNull(accountEntity) ?
                 accountMapper.accountToEntity(this.accountService.findAccount(accountEntity.getId()))   : null;
    }
}
