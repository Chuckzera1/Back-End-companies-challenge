package com.accenture.challenge.infra.models.company;

import com.accenture.challenge.utils.entities.Company;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Table(name = "companies")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tradeName;
    @Column(nullable = false, unique = true)
    private String document;
    @Column(nullable = false)
    private String cep;
    @ManyToMany
    @JoinTable(name = "relation_company_supplier", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<SupplierModel> suppliers;

    public CompanyModel(Company company) {
        this.id = company.getId();
        this.tradeName = company.getTradeName();
        this.document = company.getDocument();
        this.cep = company.getCep();
        this.suppliers = company.getSuppliers().stream().map(SupplierModel::new).toList();
    }

    public Company toCompany() {
        return new Company(this.getId(), this.getTradeName(), this.getDocument(), this.getCep());
    }
}
