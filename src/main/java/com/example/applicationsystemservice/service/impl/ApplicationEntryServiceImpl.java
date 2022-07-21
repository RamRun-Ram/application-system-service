package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.dto.ApplicationEntryDTO;
import com.example.applicationsystemservice.domain.entity.ApplicationEntryEntity;
import com.example.applicationsystemservice.domain.enums.ApplicationStatus;
import com.example.applicationsystemservice.mapper.ApplicationEntryMapper;
import com.example.applicationsystemservice.service.ApplicationEntryService;
import com.example.applicationsystemservice.service.repository.ApplicationEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationEntryServiceImpl implements ApplicationEntryService {
    private final ApplicationEntryRepository applicationEntryRepository;
    private final ApplicationEntryMapper applicationEntryMapper;


    @Override
    public List<ApplicationEntryDTO> getApplicationEntryDto(Long projectId, String status) {
        return applicationEntryRepository.findAll().stream()
                .filter(applicationEntryEntity -> filterApplicationEntryEntity(applicationEntryEntity, projectId, status))
                .map(applicationEntryMapper::applicationEntryToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationEntryDTO createApplicationEntryDto(ApplicationEntryDTO applicationEntryDTO) {
        ApplicationEntryEntity applicationEntryEntity= applicationEntryRepository.save(applicationEntryMapper.applicationDtoToEntity(applicationEntryDTO));
        return applicationEntryMapper.applicationEntryToDto(applicationEntryEntity);
    }

    @Override
    public ApplicationEntryDTO updateApplicationEntryByDeveloper(ApplicationEntryDTO applicationEntryDTO) {
        Optional<ApplicationEntryEntity> applicationEntryEntityOptional=
                applicationEntryRepository.findById(applicationEntryDTO.getId());
        if (applicationEntryEntityOptional.isPresent()&& applicationEntryEntityOptional.get().getApplicationStatus()==
                ApplicationStatus.NEW){
           ApplicationEntryEntity applicationEntryEntity= applicationEntryEntityOptional.get();
           applicationEntryEntity.setCommentApplicant(applicationEntryDTO.getCommentApplicant());
           return applicationEntryMapper.applicationEntryToDto(applicationEntryRepository.save(applicationEntryEntity));
        }
        throw new RuntimeException();
    }

    public ApplicationEntryDTO updateApplicationEntryByAdmin(ApplicationEntryDTO applicationEntryDTO){
        Optional<ApplicationEntryEntity> applicationEntryEntityOptional =
                applicationEntryRepository.findById(applicationEntryDTO.getId());
        if (applicationEntryEntityOptional.isPresent()&& applicationEntryEntityOptional.get().getApplicationStatus()==
        ApplicationStatus.NEW){
            ApplicationEntryEntity applicationEntryEntity = applicationEntryEntityOptional.get();

            if (applicationEntryEntity.getApplicationStatus()!=applicationEntryDTO.getApplicationStatus()
                    && !applicationEntryDTO.getCommentAdmin().isEmpty()){
                applicationEntryEntity.setApplicationStatus(applicationEntryDTO.getApplicationStatus());
                applicationEntryEntity.setCommentAdmin(applicationEntryDTO.getCommentAdmin());
                return applicationEntryMapper.applicationEntryToDto(applicationEntryRepository.save(applicationEntryEntity));
            }
        }
        throw new RuntimeException();
    }

    private boolean filterApplicationEntryEntity(ApplicationEntryEntity applicationEntryEntity, Long projectId,
                                                 String status) {
        if (projectId != null && status != null) {
            return applicationEntryEntity.getProject().getId().equals(projectId)
                    && applicationEntryEntity.getApplicationStatus().name().equals(status);
        } else if (projectId != null) {
            return applicationEntryEntity.getProject().getId().equals(projectId);
        } else if (status != null) {
            return applicationEntryEntity.getApplicationStatus().name().equals(status);
        } else {
            return true;
        }
    }
}
