package com.dio.santander.bankline.api.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Account {
    @Column(name = "account_number")
    private Long number;

    @Column(name = "account_balance")
    private Double balance;


}
