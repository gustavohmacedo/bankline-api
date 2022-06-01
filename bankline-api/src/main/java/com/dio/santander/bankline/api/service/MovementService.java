package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.model.TypeMovement;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
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

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public Movement save(Movement newMovement) {
        Movement movement = new Movement();
        Double amount = newMovement.getAmount();

        if (newMovement.getType().equals(TypeMovement.EXPENDITURE)) {
            amount *= -1;
        }
        movement.setAmount(amount);
        movement.setDateTime(LocalDateTime.now());
        movement.setDescription(newMovement.getDescription());
        movement.setType(newMovement.getType());
        movement.setIdAccount(newMovement.getIdAccount());

        AccountHolder accountHolder = accountHolderRepository
                .findById(newMovement.getIdAccount()).orElse(null);
        if (accountHolder != null) {
            accountHolder.getAccount().setBalance(accountHolder.getAccount().getBalance() + amount);
            accountHolderRepository.save(accountHolder);

        }

        return movementRepository.save(movement);

    }

    public Page<Movement> getAll(Pageable page) {
        return movementRepository.findAll(page);
    }
}
