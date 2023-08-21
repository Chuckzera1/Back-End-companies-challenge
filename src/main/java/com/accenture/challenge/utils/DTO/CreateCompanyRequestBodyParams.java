package com.accenture.challenge.utils.DTO;

import com.accenture.challenge.utils.entities.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequestBodyParams {
    @NotNull
    @NotBlank(message = "document is required")
    private String document;

    @NotNull
    @NotBlank(message = "tradeName is Required")
    private String tradeName;

    @NotNull
    @NotBlank(message = "cep is Required")
    private String cep;

    public Company company() {
        return new Company(this.getTradeName(), this.getDocument(), this.getCep());
    }
}
