package com.accenture.challenge.infra.repositories;

import com.accenture.challenge.application.repositories.company.*;
import com.accenture.challenge.infra.models.company.CompanyModel;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostgresCompanyRepository implements CreateCompanyRepository,
        ListCompanyRepository,
        ListWithFilterCompanyRepository,
        RemoveCompanyRepository,
        FindByDocumentRepository,
        UpdateCompanyRepository,
        FindCompanyByIdRepository {

    private final CompanyDatabaseInterface companyDataBase;

    public PostgresCompanyRepository(CompanyDatabaseInterface companyDataBase) {
        this.companyDataBase = companyDataBase;
    }

    public Company create(Company company) {
        return companyDataBase.save(new CompanyModel(company)).toCompany();
    }

    public List<Company> list() {
        return companyDataBase.findAll().stream().map(CompanyModel::toCompany).collect(Collectors.toList());
    }

    public List<Company> listWithFilter(String searchTerm) {
        return companyDataBase.findByDocumentOrTradeName(searchTerm, searchTerm).stream().map(CompanyModel::toCompany).collect(Collectors.toList());
    }

    public void remove(Long id) {
        companyDataBase.deleteById(id);
        return;
    }

    public Company findByDocument(String document){
        return companyDataBase.findByDocument(document).map(CompanyModel::toCompany).orElse(null);
    }


    public Company updateCompanyById(Company company) {
        return companyDataBase.save(new CompanyModel(company)).toCompany();
    }

    public Company findById(Long id) {
        return companyDataBase.findById(id).map(CompanyModel::toCompany).orElse(null);
    }
}
