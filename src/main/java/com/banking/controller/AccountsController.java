package com.banking.controller;

import com.banking.payload.AccountDto;
import com.banking.service.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private AccountServiceImpl accountService;

    public AccountsController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable long accountId){
        AccountDto accountDetails = accountService.getAccountDetails(accountId);
        return ResponseEntity.ok(accountDetails);

    }

    //Deposit REST API

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depoist(@PathVariable long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDto updatedAccount = accountService.depoistAmount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }
}
