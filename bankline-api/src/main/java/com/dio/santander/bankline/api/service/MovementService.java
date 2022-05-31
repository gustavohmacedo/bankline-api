package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.model.TypeMovement;
import com.dio.santander.bankline.api.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;

    public Movement save(Movement newMovement) {
        Movement movement = new Movement();

        if (newMovement.getType().equals(TypeMovement.EXPENDITURE)) {
            movement.setAmount(newMovement.getAmount() * -1);
        } else if (newMovement.getType().equals(TypeMovement.REVENUE)) {
            movement.setAmount(newMovement.getAmount());
        }
        movement.setDateTime(LocalDateTime.now());
        movement.setDescription(newMovement.getDescription());
        movement.setType(newMovement.getType());
        movement.setIdAccount(newMovement.getIdAccount());

        return movementRepository.save(movement);

    }

    public Page<Movement> getAll(Pageable page) {
        return movementRepository.findAll(page);
    }
}
