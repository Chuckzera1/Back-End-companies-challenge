package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.FindByDocumentRepository;
import com.accenture.challenge.application.repositories.company.FindCompanyByIdRepository;
import com.accenture.challenge.application.repositories.company.UpdateCompanyRepository;
import com.accenture.challenge.application.usecases.company.interfaces.UpdateCompanyUsecase;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.NoRecordFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateCompanyUsecaseImpl implements UpdateCompanyUsecase {

    private final UpdateCompanyRepository updateCompanyRepository;

    private final FindByDocumentRepository findByDocumentRepository;
    private final FindCompanyByIdRepository findCompanyByIdRepository;

    public UpdateCompanyUsecaseImpl(UpdateCompanyRepository updateCompanyRepository, FindByDocumentRepository findByDocumentRepository, FindCompanyByIdRepository findCompanyByIdRepository) {
        this.updateCompanyRepository = updateCompanyRepository;
        this.findByDocumentRepository = findByDocumentRepository;
        this.findCompanyByIdRepository = findCompanyByIdRepository;
    }
    public Company execute(Company company){
        // TODO: Validate if cep is valid
        Company companyExisted = findCompanyByIdRepository.findById(company.getId());
        if(companyExisted == null) {
            throw new NoRecordFoundException(String.format("Company with id %s not found", company.getId()));
        }
        Company companyDocumentAlreadyExisted = findByDocumentRepository.findByDocument(company.getDocument());
        if(companyDocumentAlreadyExisted != null && !Objects.equals(companyDocumentAlreadyExisted.getId(), company.getId())) {
            throw new AlreadyExistsException(String.format("Already exists a company with document %s", company.getDocument()));
        }
        return updateCompanyRepository.updateCompanyById(company);
    }
}
