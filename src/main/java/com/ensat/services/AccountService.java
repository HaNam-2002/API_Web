package com.ensat.services;
import com.ensat.entities.Account;
import com.ensat.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
    public Account findByUser(String user) {
        return accountRepository.findByUser(user);
    }
    public boolean changePassword(Account account, String oldPassword, String newPassword) {
        if (account.getPass().equals(oldPassword)) {
            account.setPass(newPassword);
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }
    public Account findById(Integer uID) {
        return accountRepository.findById(uID).orElse(null);
    }
}
