package com.accenture.challenge.utils.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Supplier {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String documentType;
    private String rg;
    private String cep;
    private Date birthDate;
    private List<Company> companies;

    public Supplier(String name, String email, String document, String documentType, String rg, String cep, Date birthDate) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.documentType = documentType;
        this.rg = rg;
        this.cep = cep;
        this.birthDate = birthDate;
        this.companies = new ArrayList<>();
    }

    public Supplier(String name, String email, String document, String documentType, String cep) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.documentType = documentType;
        this.rg = null;
        this.cep = cep;
        this.birthDate = null;
        this.companies = new ArrayList<>();
    }

    public Supplier(Long id, String name, String email, String document, String documentType, String rg, String cep, Date birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.documentType = documentType;
        this.rg = rg;
        this.cep = cep;
        this.birthDate = birthDate;
        this.companies = new ArrayList<>();
    }
}
