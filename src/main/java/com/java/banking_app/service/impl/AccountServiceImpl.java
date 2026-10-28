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
        Account account = accountMapper.mapToAccount(accountDTO);
        Account accountSaved = accountRepository.save(account);
        return accountMapper.mapToAccountDTO(accountSaved);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return accountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedBalance = accountRepository.save(account);
        return accountMapper.mapToAccountDTO(savedBalance);
    }
}
