package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.dto.DirectoryCurrencyDto;
import com.example.applicationsystemservice.domain.entity.DirectoryCurrencyEntity;
import com.example.applicationsystemservice.mapper.DirectoryCurrencyMapper;
import com.example.applicationsystemservice.service.DirectoryCurrencyService;
import com.example.applicationsystemservice.service.repository.DirectoryCurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectoryCurrencyServiceImpl implements DirectoryCurrencyService {
    private final DirectoryCurrencyRepository directoryCurrencyRepository;
    private final DirectoryCurrencyMapper directoryCurrencyMapper;

    @Override
    public DirectoryCurrencyDto createDirectoryCurrency(DirectoryCurrencyDto directoryCurrencyDto) {
        DirectoryCurrencyEntity directoryCurrencyEntity = directoryCurrencyRepository
                .save(directoryCurrencyMapper.directoryCurrencyDtoToEntity(directoryCurrencyDto));
        return directoryCurrencyMapper.directoryCurrencyEntryToDto(directoryCurrencyEntity);
    }

    @Override
    public DirectoryCurrencyDto updateDirectoryCurrency(DirectoryCurrencyDto directoryCurrencyDto) {
        if (directoryCurrencyDto.getId() != null && directoryCurrencyRepository.existsById(directoryCurrencyDto.getId())) {
            DirectoryCurrencyEntity directoryCurrencyEntity = directoryCurrencyRepository.save(directoryCurrencyMapper.directoryCurrencyDtoToEntity(directoryCurrencyDto));
            return directoryCurrencyMapper.directoryCurrencyEntryToDto(directoryCurrencyEntity);
        }
        throw new RuntimeException();
    }

    @Override
    public Page<DirectoryCurrencyDto> findAll(int number, int size) {
        Page<DirectoryCurrencyEntity> directoryCurrencyEntityPage = directoryCurrencyRepository.findAll(PageRequest.of(number, size));
        return directoryCurrencyEntityPage.map(directoryCurrencyMapper::directoryCurrencyEntryToDto);
    }
}
