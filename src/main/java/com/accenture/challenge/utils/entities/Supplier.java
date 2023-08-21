package com.accenture.challenge.utils.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Supplier {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String documentType;
    private String rg;
    private String cep;
    private Date birthDate;

    public Supplier(String name, String email, String document, String documentType, String rg, String cep, Date birthDate) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.documentType = documentType;
        this.rg = rg;
        this.cep = cep;
        this.birthDate = birthDate;
    }

    public Supplier(String name, String email, String document, String documentType, String cep) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.documentType = documentType;
        this.rg = null;
        this.cep = cep;
        this.birthDate = null;
    }
}
