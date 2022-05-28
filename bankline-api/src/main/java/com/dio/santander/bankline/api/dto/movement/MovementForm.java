package com.dio.santander.bankline.api.dto.movement;

import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.model.TypeMovement;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MovementForm {
    @NotBlank(message = "Description cannot be blank")
    @Length(min = 4, max = 20)
    private String description;

    @NotBlank(message = "Amount cannot be blank")
    private Double amount;

    @NotBlank(message = "Type cannot be blank")
    private TypeMovement type;

    @NotBlank(message = "idAccount cannot be blank")
    private Long idAccount;

    public Movement convertToEntity() {
        return new Movement(this.description, this.amount, this.type, this.idAccount);
    }
}
