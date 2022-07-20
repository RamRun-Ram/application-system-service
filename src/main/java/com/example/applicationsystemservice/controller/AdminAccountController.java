package com.example.applicationsystemservice.controller;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.dto.ApplicationEntryDTO;
import com.example.applicationsystemservice.service.ApplicationEntryService;
import com.example.applicationsystemservice.service.impl.ApplicationEntryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ramil
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminAccountController {
    private ApplicationEntryService applicationEntryService;

    @PostMapping
    public ApplicationEntryDTO createAccount(@RequestBody ApplicationEntryDTO applicationEntryDTO) {
        return applicationEntryService.createApplicationEntryDto(applicationEntryDTO);
    }

    @PutMapping
    public ApplicationEntryDTO updateAccount(@RequestBody ApplicationEntryDTO applicationEntryDTO) {
        return applicationEntryService.updateApplicationEntryByAdmin(applicationEntryDTO);
    }



}
