package com.dio.santander.bankline.api.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Movement {
    private Integer id;
    private Date dateTime;
    private String description;
    private Double value;
    private TypeMovement type;

}
