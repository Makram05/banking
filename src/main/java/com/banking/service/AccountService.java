package com.banking.service;

import com.banking.payload.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);
    AccountDto getAccountDetails(long id);
    AccountDto depositAmount(long id,double amount);
    AccountDto withdrawAmount(long id, double amount);
}
