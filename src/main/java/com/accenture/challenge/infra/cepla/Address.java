package com.accenture.challenge.infra.cepla;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
}
