package com.dio.santander.bankline.api.dto.accountHolder;

import com.dio.santander.bankline.api.model.AccountHolder;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
public class AccountHolderForm {
    @CPF(message = "Invalid CPF")
    @NotBlank(message = "CPF cannot be blank")
    @Length(min = 11, max = 11)
    private String cpf;
    
    @NotBlank(message = "Name cannot be blank")
    @Length(min = 10, max = 60)
    private String name;

    public AccountHolder convertToEntity() {
        return new AccountHolder(this.cpf, this.name);
    }
}
