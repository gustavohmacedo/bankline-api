package com.dio.santander.bankline.api.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "tb_movimentacao")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time")
    private Date dateTime;

    private String description;

    private Double value;

    @Enumerated(EnumType.STRING)
    private TypeMovement type;

}
