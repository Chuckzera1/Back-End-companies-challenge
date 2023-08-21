package com.accenture.challenge.infra.repositories;

import com.accenture.challenge.application.repositories.company.*;
import com.accenture.challenge.infra.models.company.CompanyModel;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostgresCompanyRepository implements CreateCompanyRepository, ListCompanyRepository, RemoveCompanyRepository, FindByDocumentRepository {

    private final CompanyDatabaseInterface companyDataBase;

    public PostgresCompanyRepository(CompanyDatabaseInterface companyDataBase) {
        this.companyDataBase = companyDataBase;
    }

    @Override
    public Company create(Company company) {
        return companyDataBase.save(new CompanyModel(company)).toCompany();
    }


    @Override
    public List<Company> list() {
        return companyDataBase.findAll().stream().map(CompanyModel::toCompany).collect(Collectors.toList());
    }

    public void remove(Long id) {
        companyDataBase.deleteById(id);
        return;
    }

    public Company findByDocument(String document){
        return companyDataBase.findByDocument(document).map(CompanyModel::toCompany).orElse(null);
    }
}
