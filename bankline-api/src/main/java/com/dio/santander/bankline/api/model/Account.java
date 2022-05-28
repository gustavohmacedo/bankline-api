package com.dio.santander.bankline.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Account {

    @Column(name = "account_number")
    private Long number;

    @Column(name = "account_balance")
    private Double balance;


}
