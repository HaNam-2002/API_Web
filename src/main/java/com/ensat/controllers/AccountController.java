package com.ensat.controllers;

import com.ensat.entities.Account;
import com.ensat.entities.PasswordChangeRequest;
import com.ensat.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequestMapping("/accounts")  // http://localhost:8083/accounts
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
    public ResponseEntity<Account> login(@RequestParam String user, @RequestParam String pass,HttpSession session) {
        System.out.println("login");
        Account account = accountService.findByUser(user);
        if (account != null && account.getPass().equals(pass)) {
            account.setPass("");
            session.setAttribute("uID", account.getuID());
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PutMapping("/changePassword/{uID}")
    public ResponseEntity<?> changePassword(@PathVariable Integer uID, @RequestBody PasswordChangeRequest request) {
        Account account = accountService.findById(uID);
        if (account != null) {
            boolean isChanged = accountService.changePassword(account, request.getOldPassword(), request.getNewPassword());
            if (isChanged) {
                return ResponseEntity.ok("Password changed successfully.");
            } else {
                return ResponseEntity.badRequest().body("Incorrect old password.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

