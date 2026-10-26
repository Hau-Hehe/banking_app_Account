package com.java.banking_app.mapper;

import com.java.banking_app.dto.AccountDTO;
import com.java.banking_app.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}