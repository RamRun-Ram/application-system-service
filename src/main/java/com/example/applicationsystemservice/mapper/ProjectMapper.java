package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.ProjectDto;
import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {
    ProjectDto projectToDto(ProjectEntity projectEntity);
    ProjectEntity projectToEntity(ProjectDto projectDto);
}
