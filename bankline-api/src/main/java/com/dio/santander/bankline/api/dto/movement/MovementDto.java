package com.dio.santander.bankline.api.dto.movement;

import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.model.TypeMovement;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class MovementDto {
    private Long id;
    private String description;
    private Double amount;
    private TypeMovement type;
    private Long idAccount;

    public MovementDto(Movement movement) {
        this.id = movement.getId();
        this.description = movement.getDescription();
        this.amount = movement.getAmount();
        this.type = movement.getType();
        this.idAccount = movement.getIdAccount();
    }

    public static Page<MovementDto> returnMovementsDto(Page<Movement> movements) {
        return movements.map(MovementDto::new);
    }
}

