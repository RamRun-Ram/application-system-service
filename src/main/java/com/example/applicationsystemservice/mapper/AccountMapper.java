package com.example.applicationsystemservice.mapper;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.entity.AccountEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountDto accountToDto(AccountEntity accountEntity);
    AccountEntity accountToEntity(AccountDto accountDto);
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "address",ignore = true),
            @Mapping(target = "payPeriod",ignore = true),
            @Mapping(target = "bet",ignore = true),
            @Mapping(target = "currency",ignore = true),
            @Mapping(target = "password", ignore = true)
    })
    AccountEntity accountToEntity(@MappingTarget AccountEntity accountEntity, AccountDto accountDto);


}
