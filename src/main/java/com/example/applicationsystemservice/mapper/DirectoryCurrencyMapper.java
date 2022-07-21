package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.DirectoryCurrencyDto;
import com.example.applicationsystemservice.domain.entity.DirectoryCurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DirectoryCurrencyMapper {
    DirectoryCurrencyDto directoryCurrencyEntryToDto(DirectoryCurrencyEntity directoryCurrencyEntity);
    DirectoryCurrencyEntity directoryCurrencyDtoToEntity(DirectoryCurrencyDto directoryCurrencyDto);
}
