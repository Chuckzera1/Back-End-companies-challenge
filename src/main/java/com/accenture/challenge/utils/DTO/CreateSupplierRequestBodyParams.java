package com.accenture.challenge.utils.DTO;

import com.accenture.challenge.utils.entities.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequestBodyParams {
    @NotNull
    @NotBlank(message = "document is required")
    private String document;

    @NotNull
    @NotBlank(message = "name is Required")
    private String name;

    @NotNull
    @NotBlank(message = "email is Required")
    private String email;

    @NotNull
    @NotBlank(message = "cep is Required")
    private String cep;

    @NotNull
    @NotBlank
    private String documentType;

    private String rg;
    private Date birthDate;

    public Supplier supplier() {
        return new Supplier(this.getName(), this.getEmail(), this.getDocument(), this.getDocumentType(), this.getRg(), this.getCep(), this.getBirthDate());
    }
}
