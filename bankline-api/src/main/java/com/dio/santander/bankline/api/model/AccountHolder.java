package com.dio.santander.bankline.api.model;

import lombok.Getter;

@Getter
public class AccountHolder {
    private Integer id;
    private String cpf;
    private String name;
    private Account account;

}
