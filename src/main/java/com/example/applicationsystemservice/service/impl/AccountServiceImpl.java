package com.example.applicationsystemservice.service.impl;

import com.example.applicationsystemservice.domain.dto.AccountDto;
import com.example.applicationsystemservice.domain.entity.AccountEntity;
import com.example.applicationsystemservice.domain.entity.RoleEntity;
import com.example.applicationsystemservice.mapper.AccountMapper;
import com.example.applicationsystemservice.service.AccountService;
import com.example.applicationsystemservice.service.RoleService;
import com.example.applicationsystemservice.service.repository.AccountRepository;
import com.example.applicationsystemservice.service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdmin() {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(1L);
        Optional<RoleEntity> roleEntityOptional = roleService.findById(1L);

        if ((optionalAccountEntity.isEmpty() || optionalAccountEntity.get().getRole().getRoleName().equals("admin"))
                && roleEntityOptional.isPresent() ) {
            RoleEntity roleEntity= roleEntityOptional.get();
            accountRepository.save(new AccountEntity(1L, "admin", "admin@gmail.com",
                    passwordEncoder.encode("12345"), LocalDateTime.of(2022,12,23,
                    12,13) , "Ivanov Ivan Ivanovich", "Moscow...", "12.12.2000",
                    roleEntity));
        }
    }

    @Override
    public AccountDto findAccount(Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        return accountMapper.accountToDto(accountEntity);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        RoleEntity roleEntity = roleService.findByName("developer");
        AccountEntity accountEntity = accountMapper.accountToEntity(accountDto);
        accountEntity.setRole(roleEntity);
        accountEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return accountMapper.accountToDto(accountRepository.save(accountEntity));
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountDto.getId());
        if (optionalAccountEntity.isPresent()) {
            AccountEntity accountEntity = accountRepository
                    .save(accountMapper.accountToEntity(optionalAccountEntity.get(), accountDto));
            return accountMapper.accountToDto(accountEntity);
        }
        throw new RuntimeException();
    }

    @Override
    public void setRole(Long id, RoleEntity role) {
        accountRepository.findById(id)
                .ifPresentOrElse(accountEntity -> {
                            accountEntity.setRole(role);
                            accountRepository.save(accountEntity);
                        },
                        () -> {
                            throw new RuntimeException();
                        });
    }

    @Override
    public boolean deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity= accountRepository.findByLogin(username);
        if (accountEntity==null){
            throw new UsernameNotFoundException("User not found");
        }
        return accountEntity;
    }
}
