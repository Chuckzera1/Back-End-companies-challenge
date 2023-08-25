package com.accenture.challenge.utils.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Company {
    private Long id;
    private String tradeName;
    private String document;
    private String cep;
    private String stateUf;
    private List<Supplier> suppliers;

    public void AddSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    public Company(Long id, String tradeName, String document, String cep, String stateUf) {
        this.id = id;
        this.tradeName = tradeName;
        this.document = document;
        this.cep = cep;
        this.stateUf = stateUf;
        this.suppliers = new ArrayList<>();

    }
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
    public Company(String tradeName, String document, String cep, String stateUf) {
        this.tradeName = tradeName;
        this.document = document;
        this.cep = cep;
        this.stateUf = stateUf;
        this.suppliers = new ArrayList<>();

    }
}