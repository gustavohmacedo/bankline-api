package com.dio.santander.bankline.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_correntista")
@NoArgsConstructor
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11)
    private String cpf;

    @Column(length = 60)
    private String name;

    @Embedded
    private Account account;

    public AccountHolder(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
}
