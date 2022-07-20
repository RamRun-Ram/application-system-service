package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.dto.ProjectDto;
import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import com.example.applicationsystemservice.mapper.ProjectMapper;
import com.example.applicationsystemservice.service.ProjectService;
import com.example.applicationsystemservice.service.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        ProjectEntity projectEntity = projectRepository.save(projectMapper.projectToEntity(projectDto));
        return projectMapper.projectToDto(projectEntity);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        if (projectDto.getId() != null && projectRepository.existsById(projectDto.getId())) {
            ProjectEntity projectEntity = projectRepository.save(projectMapper.projectToEntity(projectDto));
            return projectMapper.projectToDto(projectEntity);
        }
//       ошибка
        return null;
    }
}
