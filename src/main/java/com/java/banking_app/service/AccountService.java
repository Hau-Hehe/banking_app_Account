package com.java.banking_app.service;

import com.java.banking_app.dto.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(AccountDTO account);
    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id, double amount);
}
