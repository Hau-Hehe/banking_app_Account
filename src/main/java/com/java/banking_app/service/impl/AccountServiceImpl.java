package com.java.banking_app.service.impl;

import com.java.banking_app.dto.AccountDTO;
import com.java.banking_app.entity.Account;
import com.java.banking_app.mapper.AccountMapper;
import com.java.banking_app.repository.AccountRepository;
import com.java.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account accountSaved = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(accountSaved);
    }
}
