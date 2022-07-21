package com.example.applicationsystemservice.domain.entity;

import com.example.applicationsystemservice.domain.enums.PayPeriodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;
    private LocalDateTime timeCreateAccount;
    private String FIO;
    private String address;
    private String birthday;
    private PayPeriodEntity payPeriod;
    private String bet;
    private String currency;
    @ManyToOne
    private RoleEntity role;


    public AccountEntity(Long id, String login, String email, String password,
                         LocalDateTime createTime, String FIO, String address, String birthday, RoleEntity role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.timeCreateAccount = createTime;
        this.FIO = FIO;
        this.address = address;
        this.birthday = birthday;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(getRole());
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
