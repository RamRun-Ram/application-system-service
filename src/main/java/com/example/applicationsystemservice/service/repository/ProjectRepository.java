package com.example.applicationsystemservice.service.repository;

import com.example.applicationsystemservice.domain.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {
}
