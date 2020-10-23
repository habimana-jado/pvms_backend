package com.kist.pvms.service;

import com.kist.pvms.domain.Account;
import com.kist.pvms.domain.CrimeCase;
import com.kist.pvms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizey on 8/18/2020.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findByUsernameAndPassword(String username, String password){
        List<Account> accounts = new ArrayList<>();
        Iterable<Account> accountIterable = this.accountRepository.findByUsernameAndPassword(username, password);
        accountIterable.forEach(accounts::add);
        return accounts;
    }
}
