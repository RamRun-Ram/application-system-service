package com.example.applicationsystemservice.domain.entity;

import com.example.applicationsystemservice.domain.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AccountEntity account;
    @OneToOne
    private ProjectEntity project;
    private String commentApplicant;
    private String commentAdmin;
    private ApplicationStatus applicationStatus;
    private LocalDate dateCreateApplication;

}

