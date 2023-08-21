package com.accenture.challenge.application.usecases.company;


import com.accenture.challenge.application.repositories.company.CreateCompanyRepository;
import com.accenture.challenge.application.repositories.company.FindByDocumentRepository;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUsecase {
    private final CreateCompanyRepository createCompanyRepository;
    private final FindByDocumentRepository findByDocumentRepository;

    public CreateCompanyUsecase(CreateCompanyRepository createCompanyRepository, FindByDocumentRepository findByDocumentRepository) {
        this.createCompanyRepository = createCompanyRepository;
        this.findByDocumentRepository = findByDocumentRepository;
    }

    public Company execute(Company company){
        // TODO: Validate if cep is valid
        Company companyAlreadyExisted = findByDocumentRepository.findByDocument(company.getDocument());
        if(companyAlreadyExisted != null) {
            throw new AlreadyExistsException(String.format("Already exists a company with document %s", company.getDocument()));
        }
        return createCompanyRepository.create(company);
    }
}
