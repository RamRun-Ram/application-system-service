package com.example.applicationsystemservice.config.security;

import com.example.applicationsystemservice.domain.dto.LoginDto;
import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.service.AccountService;
import com.example.applicationsystemservice.service.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
@RequiredArgsConstructor
public class UserAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTH_PATH = "/login";
    private static final String TOKEN_HEADER = "TOKEN";

    private final ObjectMapper objectMapper;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LoginDto loginDto = objectMapper.readValue(request.getReader(), LoginDto.class);
        AccountEntity accountEntity = accountService.findByLogin(loginDto.getUsername());
        if (accountEntity != null && passwordEncoder.matches(loginDto.getPassword(), accountEntity.getPassword())) {
            String token = jwtTokenService.generateToken(accountEntity.getLogin(),
                    accountEntity.getRole().getRoleName());
            response.setHeader(TOKEN_HEADER, token);
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals(AUTH_PATH);
    }
}
