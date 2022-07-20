package com.example.applicationsystemservice.domain.dto;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectDescription;
    private AccountEntity account;
    private String currency;
    private LocalDateTime dataCreateProject;
}
