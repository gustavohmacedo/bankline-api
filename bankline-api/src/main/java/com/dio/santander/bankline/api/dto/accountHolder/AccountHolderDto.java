package com.dio.santander.bankline.api.dto.accountHolder;

import com.dio.santander.bankline.api.model.Account;
import com.dio.santander.bankline.api.model.AccountHolder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class AccountHolderDto {
    private Long id;
    private String cpf;
    private String name;
    private Account account;

    public AccountHolderDto(AccountHolder accountHolder) {
        this.id = accountHolder.getId();
        this.cpf = accountHolder.getCpf();
        this.name = accountHolder.getName();
        account = new Account();
        account.setBalance(accountHolder.getAccount().getBalance());
        account.setNumber(accountHolder.getAccount().getNumber());

    }

    public static Page<AccountHolderDto> retrieveAccountHoldersDto(Page<AccountHolder> accountHolders) {
        return accountHolders.map(AccountHolderDto::new);
    }
}
