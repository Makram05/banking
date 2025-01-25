package com.banking.service;

import com.banking.entity.Accounts;
import com.banking.payload.AccountDto;
import com.banking.repository.AccountsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private ModelMapper modelMapper;
    private AccountsRepository accountsRepository;

    public AccountServiceImpl(ModelMapper modelMapper, AccountsRepository accountsRepository) {
        this.modelMapper = modelMapper;
        this.accountsRepository = accountsRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto account) {
        Accounts accounts = mapToEntity(account);
        Accounts saved = accountsRepository.save(accounts);
        return mapToDto(saved);

    }

    //AccountMapper
    Accounts mapToEntity(AccountDto dto){
        Accounts map = modelMapper.map(dto, Accounts.class);
        return map;
    }

   AccountDto mapToDto(Accounts accounts){
       AccountDto map = modelMapper.map(accounts, AccountDto.class);
       return map;
   }

    public AccountDto getAccountDetails(long accountId) {
        Accounts accountsDetail = accountsRepository.findById(accountId).orElseThrow(() -> new RuntimeException("account details not found"));
        return mapToDto(accountsDetail);
    }

    public AccountDto depoistAmount(long id,double amount) {
        Accounts accountsDetail = accountsRepository.findById(id).orElseThrow(() -> new RuntimeException("account details not found"));
        double depoisted = accountsDetail.getBalance() + amount;
        accountsDetail.setBalance(depoisted);
        Accounts saved = accountsRepository.save(accountsDetail);
        return mapToDto(saved);

    }
}
