package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.ListCompanyRepository;
import com.accenture.challenge.application.repositories.company.ListWithFilterCompanyRepository;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCompaniesUsecase {

    private final ListCompanyRepository listCompanyRepository;
    private final ListWithFilterCompanyRepository listWithFilterCompanyRepository;


    public ListCompaniesUsecase(ListCompanyRepository listCompanyRepository, ListWithFilterCompanyRepository listWithFilterCompanyRepository) {
        this.listCompanyRepository = listCompanyRepository;
        this.listWithFilterCompanyRepository = listWithFilterCompanyRepository;
    }

    public List<Company> execute(String searchTerm){
        if(searchTerm != null){
            return listWithFilterCompanyRepository.listWithFilter(searchTerm);
        }
        return listCompanyRepository.list();
    }
}
