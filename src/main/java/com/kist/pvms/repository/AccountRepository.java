package com.kist.pvms.repository;

import com.kist.pvms.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    public List<Account> findByUsernameAndPassword(String username, String password);
}
