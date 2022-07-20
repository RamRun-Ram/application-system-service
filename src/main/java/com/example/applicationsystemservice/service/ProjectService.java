package com.example.applicationsystemservice.service;

import com.example.applicationsystemservice.domain.dto.ProjectDto;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto updateProject(ProjectDto projectDto);
}
