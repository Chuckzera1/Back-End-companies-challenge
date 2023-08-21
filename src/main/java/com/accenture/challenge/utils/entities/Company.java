package com.accenture.challenge.utils.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Company {
    private Long id;
    @Getter private String tradeName;
    @Getter private String document;
    @Getter private String cep;

    public Company(String tradeName, String document, String cep) {
        this.tradeName = tradeName;
        this.document = document;
        this.cep = cep;
    }
}