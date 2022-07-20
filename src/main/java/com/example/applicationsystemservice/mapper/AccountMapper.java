package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.domain.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper
public interface AccountMapper {
    AccountDto accountToDto(AccountEntity accountEntity);
    AccountEntity accountToEntity(AccountDto accountDto, RoleEntity role);
    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "address",ignore = true),
            @Mapping(target = "payPeriod",ignore = true),
            @Mapping(target = "bet",ignore = true),
            @Mapping(target = "currency",ignore = true)
    })
    AccountEntity accountToEntity(@MappingTarget AccountEntity accountEntity, AccountDto accountDto);


}
