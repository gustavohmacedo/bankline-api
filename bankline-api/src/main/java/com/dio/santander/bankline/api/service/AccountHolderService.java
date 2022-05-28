package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.Account;
import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountHolderService {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public AccountHolder save(AccountHolder newAccountHolder) {

        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setCpf(newAccountHolder.getCpf());
        accountHolder.setName(newAccountHolder.getName());

        Account account = new Account();
        account.setBalance(0.0);
        account.setNumber(new Date().getTime());

        accountHolder.setAccount(account);
        return accountHolderRepository.save(accountHolder);

    }

    public Page<AccountHolder> getAll(Pageable pageable) {
        return accountHolderRepository.findAll(pageable);
    }
}


