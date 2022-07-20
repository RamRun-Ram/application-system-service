package com.example.applicationsystemservice.service;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.dto.DirectoryCurrencyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DirectoryCurrencyService {
    DirectoryCurrencyDto createDirectoryCurrency(DirectoryCurrencyDto directoryCurrencyDto);
    DirectoryCurrencyDto updateDirectoryCurrency(DirectoryCurrencyDto DirectoryCurrencyDto);
    Page<DirectoryCurrencyDto> findAll(int number,int size);
}
