package com.example.applicationsystemservice.config.security;

import com.example.applicationsystemservice.service.AccountService;
import com.example.applicationsystemservice.service.impl.JwtTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService accountService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HandlerExceptionResolver defaultHandlerExceptionResolver(){
        return new DefaultHandlerExceptionResolver();
    }

    @Autowired
    private JwtTokenRepository jwtTokenRepository;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(this.accountService);

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy
                        .NEVER)
                .and()
                .addFilterAt(new
                        JwtCsrfFilter(jwtTokenRepository, defaultHandlerExceptionResolver()), CsrfFilter.class)
                .csrf().ignoringAntMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login")
                .authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(((request,
                                            response, e) -> defaultHandlerExceptionResolver().resolveException(request, response,
                        null, e)));

//                .csrf()
//                .disable()
//                .authorizeRequests()
////                .antMatchers("/account/create").not().fullyAuthenticated()
////                .antMatchers("/account/create").hasRole("admin")
////                .antMatchers("/news").hasRole("USER")
////                .antMatchers("/", "/resources/**").permitAll()
//                .antMatchers("/login*").not().authenticated()
//                .and()
////                .formLogin()
////                .disable()
//                .logout()
//                .permitAll();
    }
}
