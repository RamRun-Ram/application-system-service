package com.example.applicationsystemservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/app/{\\d+}/edit", "/app/{\\d+}/delete", "/app/add",
                        "/api/{\\d+}/edit", "/api/{\\d+}/delete", "/api/add").hasRole("admin")
                .antMatchers("/login*").not().authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .defaultSuccessUrl("/app/list");
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
////                .antMatchers("/account/create").not().fullyAuthenticated()
////                //Доступ только для пользователей с ролью Администратор
////                .antMatchers("/account/create").hasRole("admin")
////                .antMatchers("/news").hasRole("USER")
////                //Доступ разрешен всем пользователей
////                .antMatchers("/", "/resources/**").permitAll()
////                //Все остальные страницы требуют аутентификации
//                .antMatchers("/login*").not().authenticated()
//                .and()
//                //Настройка для входа в систему
////                .formLogin()
////                .disable()
//                .logout()
//                .permitAll();


    }
}
