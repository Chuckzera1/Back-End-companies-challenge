package com.accenture.challenge.application.usecases.company;


import com.accenture.challenge.application.repositories.company.CreateCompanyRepository;
import com.accenture.challenge.application.repositories.company.FindByDocumentRepository;
import com.accenture.challenge.application.usecases.CheckIfCepIsValidUsecase;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.InvalidCepException;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUsecase {
    private final CreateCompanyRepository createCompanyRepository;
    private final FindByDocumentRepository findByDocumentRepository;
    private final CheckIfCepIsValidUsecase checkIfCepIsValidUsecase;

    public CreateCompanyUsecase(CreateCompanyRepository createCompanyRepository, FindByDocumentRepository findByDocumentRepository, CheckIfCepIsValidUsecase checkIfCepIsValidUsecase) {
        this.createCompanyRepository = createCompanyRepository;
        this.findByDocumentRepository = findByDocumentRepository;
        this.checkIfCepIsValidUsecase = checkIfCepIsValidUsecase;
    }

    public Company execute(Company company){
        Company companyAlreadyExisted = findByDocumentRepository.findByDocument(company.getDocument());
        if(companyAlreadyExisted != null) {
            throw new AlreadyExistsException(String.format("Already exists a company with document %s", company.getDocument()));
        }
        String uf = checkIfCepIsValidUsecase.exec(company.getCep());
        if(uf == null) {
            throw new InvalidCepException(String.format("The following CEP is invalid %s", company.getCep()));
        }
        Company companyToCreate = new Company(company.getTradeName(),company.getDocument(), company.getCep(),uf);
        return createCompanyRepository.create(companyToCreate);
    }
}
