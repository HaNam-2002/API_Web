package com.ensat.controllers;

import com.ensat.entities.Account;
import com.ensat.entities.Category;
import com.ensat.entities.PasswordChangeRequest;
import com.ensat.entities.Product;
import com.ensat.payload.request.LoginRequest;
import com.ensat.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@RequestMapping("/accounts")  // http://localhost:8083/accounts
@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/all")
    public ResponseEntity<List<Account>> list() {
        return new ResponseEntity<>(accountService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/get/{uID}")
    public ResponseEntity<Account> get(@PathVariable Integer uID) {
        try {
            Account account= accountService.get(uID);
            return  new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (NoSuchFieldError e) {
            return  new  ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/add")
    public  void add(@RequestBody Account account ) {
        accountService.save(account) ;
    }
    @PutMapping("/{uID}")
    public ResponseEntity<?> update(@RequestBody Account account,
                                    @PathVariable Integer uID) {
        Account exitCategory = accountService.get(uID);
        if(exitCategory == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        accountService.save(account);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{uID}")
    public void delete(@PathVariable Integer uID) {
        accountService.delete(uID);
    }
    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody() Account account) {
        try {
            Account newAccount = accountService.createAccount(account);
            return ResponseEntity.ok(newAccount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody() LoginRequest loginRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Account account = accountService.findByUser(loginRequest.getUser(), loginRequest.getPass());
        System.out.println(account);
        if (account != null) {
            account.setPass("");
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PutMapping("/changePassword/{uID}")
    public ResponseEntity<?> changePassword(@PathVariable() Integer uID, @RequestBody PasswordChangeRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(uID);
        if (uID != null) {
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
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired or not logged in.");
        }
    }
}

