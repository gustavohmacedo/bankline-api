package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;

    public Movement save(Movement movement) {
        return movementRepository.save(movement);

    }

    public Page<Movement> getAll(Pageable pageable) {
        return movementRepository.findAll(pageable);
    }
}
