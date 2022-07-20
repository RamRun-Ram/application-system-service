package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.DirectoryCurrencyDto;
import com.example.applicationsystemservice.domain.entity.DirectoryCurrencyEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DirectoryCurrencyMapper {
    DirectoryCurrencyDto directoryCurrencyEntryToDto(DirectoryCurrencyEntity directoryCurrencyEntity);
    DirectoryCurrencyEntity directoryCurrencyDtoToEntity(DirectoryCurrencyDto directoryCurrencyDto);
}
