package com.example.applicationsystemservice.domain.entity;

import lombok.Data;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
public class ApplicationEntryEntity {
    private AccountEntity account;
    @OneToOne
    private ProjectEntity project;
    private String commentApplicant;
    private String commentAdmin;
    private StatusApplication statusApplication;
    private LocalDate dateCreateApplication;

}

enum StatusApplication{
    NEW,
    APPROVED,
    CANCEL
}
