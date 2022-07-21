package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.ProjectDto;
import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
    ProjectDto projectToDto(ProjectEntity projectEntity);
    ProjectEntity projectToEntity(ProjectDto projectDto);
}
