package com.accenture.challenge.utils.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Company {
    private Long id;
    private String tradeName;
    private String document;
    private String cep;
    private List<Supplier> suppliers;

    public Company(Long id, String tradeName, String document, String cep) {
        this.id = id;
        this.tradeName = tradeName;
        this.document = document;
        this.cep = cep;
        this.suppliers = new ArrayList<>();
    }
    public Company(String tradeName, String document, String cep) {
        this.tradeName = tradeName;
        this.document = document;
        this.cep = cep;
        this.suppliers = new ArrayList<>();
    }
}