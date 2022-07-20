package com.example.applicationsystemservice.service;

import com.example.applicationsystemservice.domain.dto.ApplicationEntryDTO;

import java.util.List;

public interface ApplicationEntryService {
    List<ApplicationEntryDTO> getApplicationEntryDto(Long projectId,String status);
    ApplicationEntryDTO createApplicationEntryDto(ApplicationEntryDTO applicationEntryDTO);
    ApplicationEntryDTO updateApplicationEntryByDeveloper(ApplicationEntryDTO applicationEntryDTO);
    ApplicationEntryDTO updateApplicationEntryByAdmin(ApplicationEntryDTO applicationEntryDTO);
}
