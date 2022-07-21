package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.ApplicationEntryDTO;
import com.example.applicationsystemservice.domain.entity.ApplicationEntryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApplicationEntryMapper {
    ApplicationEntryDTO applicationEntryToDto(ApplicationEntryEntity applicationEntryEntity);
    ApplicationEntryEntity applicationDtoToEntity(ApplicationEntryDTO applicationEntryDTO);
}
