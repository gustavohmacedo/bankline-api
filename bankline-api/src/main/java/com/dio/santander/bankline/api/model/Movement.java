package com.dio.santander.bankline.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_movimentacao")
@NoArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time")
    private Date dateTime;

    private String description;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TypeMovement type;

    @Column(name = "id_account")
    private Long idAccount;

    public Movement(String description, Double amount, TypeMovement type, Long idAccount) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.idAccount = idAccount;
    }
}
