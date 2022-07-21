package com.example.applicationsystemservice.controller;

import com.example.applicationsystemservice.domain.dto.DirectoryCurrencyDto;
import com.example.applicationsystemservice.service.DirectoryCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dir")
public class DirectoryCurrencyController {
    private final DirectoryCurrencyService directoryCurrencyService;

    @PostMapping("create")
    public DirectoryCurrencyDto createDirectoryCurrency(@RequestBody DirectoryCurrencyDto directoryCurrencyDto){
        return directoryCurrencyService.createDirectoryCurrency(directoryCurrencyDto);
    }

    @PutMapping("update")
    public DirectoryCurrencyDto updateDirectoryCurrency(@RequestBody DirectoryCurrencyDto directoryCurrencyDto){
        return directoryCurrencyService.updateDirectoryCurrency(directoryCurrencyDto);
    }

    @GetMapping("all")
    public Page<DirectoryCurrencyDto> findAll(@RequestParam int number,@RequestParam int size){
       return directoryCurrencyService.findAll(number,size);
    }
}
