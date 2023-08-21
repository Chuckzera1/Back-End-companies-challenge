package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.ListCompanyRepository;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCompaniesUsecase {
    private final ListCompanyRepository companyRepository;


    public ListCompaniesUsecase(ListCompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> execute(){
        return companyRepository.list();
    }
}
