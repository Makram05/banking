package com.banking.controller;

import com.banking.payload.AccountDto;
import com.banking.service.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<AccountDto> deposit(@PathVariable long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        AccountDto updatedAccount = accountService.depositAmount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    //Withdrawal REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String,Double> request){
        Double withdrawAmount = request.get("withdrawAmount");
        AccountDto accountDto = accountService.withdrawAmount(id, withdrawAmount);
        return ResponseEntity.ok(accountDto);

    }

    //Get All Account Information REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return ResponseEntity.ok(allAccounts);
    }

    //Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id){
        String message = accountService.deleteAccount(id);
        return ResponseEntity.ok(message);
    }
}
