package com.ensat.repositories;

import com.ensat.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUser(String user);
}