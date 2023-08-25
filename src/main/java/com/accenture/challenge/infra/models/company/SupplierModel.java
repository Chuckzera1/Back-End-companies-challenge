package com.accenture.challenge.infra.models.company;

import com.accenture.challenge.utils.entities.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name="suppliers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false,unique = true)
    private String document;
    @Column(nullable = false)
    private String documentType;
    @Column(unique = true)
    private String rg;
    @Column(nullable = false)
    private String cep;
    private Date birthDate;
    @JsonIgnore
    @ManyToMany(mappedBy = "suppliers")
    private List<CompanyModel> companies;

    public SupplierModel (Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.email = supplier.getEmail();
        this.document = supplier.getDocument();
        this.documentType = supplier.getDocumentType();
        this.rg = supplier.getRg();
        this.cep = supplier.getCep();
        this.birthDate = supplier.getBirthDate();
        this.companies = supplier.getCompanies().stream().map(CompanyModel::new).toList();
    }

    public Supplier toSupplier(){
        return new Supplier(
                this.getId(),
            this.getName(),
            this.getEmail(),
            this.getDocument(),
            this.getDocumentType(),
            this.getRg(),
            this.getCep(),
            this.getBirthDate()
        );
    }
}
