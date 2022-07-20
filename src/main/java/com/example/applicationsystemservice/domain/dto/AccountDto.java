package com.example.applicationsystemservice.domain.dto;

import com.example.applicationsystemservice.domain.enums.PayPeriodEntity;
import com.example.applicationsystemservice.domain.entity.RoleEntity;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AccountDto {
    private Long id;
    private String login;
    private String email;
    private String password;
    private LocalDateTime createTime;
    private String FIO;
    private String address;
    private String birthday;
    private PayPeriodEntity payPeriod;
    private String bet;
    private String currency;
    private RoleEntity role;
}
