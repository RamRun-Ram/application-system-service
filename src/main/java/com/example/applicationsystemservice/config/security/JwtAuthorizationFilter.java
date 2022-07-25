package com.example.applicationsystemservice.config.security;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.service.AccountService;
import com.example.applicationsystemservice.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
@Order(2)
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private static final String TOKEN_HEADER = "TOKEN";
    private static final Set<String> ADMIN_PATHS = Set.of("/account/get","/create");
    private static final Set<String> DEVELOPER_PATHS = Set.of();

    private final JwtTokenService jwtTokenService;
    private final AccountService accountService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);
        if (token != null && jwtTokenService.isValid(token)) {
            String owner = jwtTokenService.getOwner(token);
            AccountEntity accountEntity = accountService.findByLogin(owner);
            if (accountEntity != null) {
                if ("admin".equals(accountEntity.getRole().getRoleName())
                        && ADMIN_PATHS.contains(request.getServletPath())) {
                    filterChain.doFilter(request, response);
                }

                if ("developer".equals(accountEntity.getRole().getRoleName())
                        && DEVELOPER_PATHS.contains(request.getServletPath())) {
                    filterChain.doFilter(request, response);
                }
            }
        }

        response.setStatus(HttpStatus.FORBIDDEN.value());
    }

}
