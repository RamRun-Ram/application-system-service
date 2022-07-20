package com.example.applicationsystemservice.service.repository;

import com.example.applicationsystemservice.domain.entity.ApplicationEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationEntryRepository extends JpaRepository<ApplicationEntryEntity,Long> {

}
