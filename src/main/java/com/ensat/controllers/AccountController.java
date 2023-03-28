package com.ensat.controllers;

import com.ensat.entities.Account;
import com.ensat.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/accounts")
@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private AccountService accountService;
        @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestParam String user, @RequestParam String pass) {
        System.out.println("login");
        Account account = accountService.findByUser(user);
        if (account != null && account.getPass().equals(pass)) {
            account.setPass("");
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}