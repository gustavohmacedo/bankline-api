package com.dio.santander.bankline.api.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tb_correntista")
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 60)
    private String name;

    @Embedded
    private Account account;

}
