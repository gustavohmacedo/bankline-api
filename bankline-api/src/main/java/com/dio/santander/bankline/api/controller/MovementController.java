package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.movement.MovementDto;
import com.dio.santander.bankline.api.dto.movement.MovementForm;
import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping
    public ResponseEntity<MovementDto> saveMovement(@RequestBody @Valid MovementForm form) {
        Movement movement = movementService.save(form.convertToEntity());
        return new ResponseEntity<>(new MovementDto(movement), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Page<MovementDto>> getAllMovements(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC, page = 0, size = 5) Pageable page) {
        Page<Movement> movements = movementService.getAll(page);
        return new ResponseEntity<>(MovementDto.returnMovementsDto(movements), HttpStatus.OK);
    }

}
