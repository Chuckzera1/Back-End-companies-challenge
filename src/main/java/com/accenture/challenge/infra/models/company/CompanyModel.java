package com.accenture.challenge.infra.models.company;

import com.accenture.challenge.utils.entities.Company;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Table(name="companies")
@Entity
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column(nullable = false)
         private String tradeName;
    @Column(nullable = false,unique = true)
        private String document;
    @Column(nullable = false)
         private String cep;

    public CompanyModel(Company company) {
         this.id = company.getId();
        this.tradeName = company.getTradeName();
        this.document = company.getDocument();
        this.cep = company.getCep();
    }

    public Company toCompany() {
        return new Company(
            this.id = getId(),
            this.tradeName = getTradeName(),
            this.document = getDocument(),
            this.cep = getCep()
        );
    }
}
