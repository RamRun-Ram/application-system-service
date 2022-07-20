package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.ApplicationEntryDTO;
import com.example.applicationsystemservice.domain.dto.ProjectDto;
import com.example.applicationsystemservice.domain.entity.ApplicationEntryEntity;
import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ApplicationEntryMapper {
    ApplicationEntryDTO applicationEntryToDto(ApplicationEntryEntity applicationEntryEntity);
    ApplicationEntryEntity applicationDtoToEntity(ApplicationEntryDTO applicationEntryDTO);
}
