package com.dio.santander.bankline.api.dto.accountHolder;

import com.dio.santander.bankline.api.model.AccountHolder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class AccountHolderDto {
    private Long id;
    private String cpf;
    private String name;

    public AccountHolderDto(AccountHolder accountHolder) {
        this.id = accountHolder.getId();
        this.cpf = accountHolder.getCpf();
        this.name = accountHolder.getName();

    }

    public static Page<AccountHolderDto> returnAccountHoldersDtoList(Page<AccountHolder> accountHolders) {
        return accountHolders.map(AccountHolderDto::new);
    }
}
