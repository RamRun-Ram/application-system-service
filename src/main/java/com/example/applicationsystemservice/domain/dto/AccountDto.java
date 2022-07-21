package com.example.applicationsystemservice.domain.dto;

import com.example.applicationsystemservice.domain.enums.PayPeriodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
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
}
