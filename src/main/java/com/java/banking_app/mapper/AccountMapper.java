package com.java.banking_app.mapper;

import com.java.banking_app.dto.AccountDTO;
import com.java.banking_app.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );
        return account;
    }

    public AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}