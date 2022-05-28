package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.accountHolder.AccountHolderDto;
import com.dio.santander.bankline.api.dto.accountHolder.AccountHolderForm;
import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.service.AccountHolderService;
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
@RequestMapping("/api/correntistas")
public class AccountHolderController {
    @Autowired
    private AccountHolderService accountHolderService;

    @PostMapping
    public ResponseEntity<AccountHolderDto> saveAccountHolder(@RequestBody @Valid AccountHolderForm form) {
        AccountHolder accountHolder = accountHolderService.save(form.convertToEntity());
        return new ResponseEntity<>(new AccountHolderDto(accountHolder), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AccountHolderDto>> getAllAccountHolders(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        Page<AccountHolder> accountHolders = accountHolderService.getAll(pageable);
        return new ResponseEntity<>(AccountHolderDto.returnAccountHoldersDtoList(accountHolders),
                HttpStatus.OK);
    }
}
