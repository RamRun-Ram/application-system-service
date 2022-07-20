package com.example.applicationsystemservice.service.repository;

import com.example.applicationsystemservice.domain.entity.DirectoryCurrencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryCurrencyRepository extends JpaRepository<DirectoryCurrencyEntity,Long> {

}
