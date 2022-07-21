package com.example.applicationsystemservice.service.repository;

import com.example.applicationsystemservice.domain.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    AccountEntity findByLogin(String username);

}
