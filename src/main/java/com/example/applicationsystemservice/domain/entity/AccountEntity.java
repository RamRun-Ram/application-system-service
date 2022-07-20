package com.example.applicationsystemservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
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
}
