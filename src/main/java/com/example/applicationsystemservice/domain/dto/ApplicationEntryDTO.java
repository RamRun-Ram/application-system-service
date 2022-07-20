package com.example.applicationsystemservice.domain.dto;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import com.example.applicationsystemservice.domain.enums.ApplicationStatus;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
@Data
public class ApplicationEntryDTO {
    private Long id;
    private AccountEntity account;
    private ProjectEntity project;
    private String commentApplicant;
    private String commentAdmin;
    private ApplicationStatus applicationStatus;
    private LocalDate dateCreateApplication;

}
