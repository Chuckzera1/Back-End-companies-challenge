package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.FindByDocumentRepository;
import com.accenture.challenge.application.repositories.company.FindCompanyByIdRepository;
import com.accenture.challenge.application.repositories.company.UpdateCompanyRepository;
import com.accenture.challenge.application.usecases.CheckIfCepIsValidUsecase;
import com.accenture.challenge.application.usecases.company.interfaces.UpdateCompanyUsecase;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.entities.Supplier;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.InvalidCepException;
import com.accenture.challenge.utils.errors.NoRecordFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
public class UpdateCompanyUsecaseImpl implements UpdateCompanyUsecase {

    private final UpdateCompanyRepository updateCompanyRepository;

    private final FindByDocumentRepository findByDocumentRepository;
    private final FindCompanyByIdRepository findCompanyByIdRepository;

    private final CheckIfCepIsValidUsecase checkIfCepIsValidUsecase;

    public UpdateCompanyUsecaseImpl(
            UpdateCompanyRepository updateCompanyRepository,
            FindByDocumentRepository findByDocumentRepository,
            FindCompanyByIdRepository findCompanyByIdRepository,
            CheckIfCepIsValidUsecase checkIfCepIsValidUsecase) {
        this.updateCompanyRepository = updateCompanyRepository;
        this.findByDocumentRepository = findByDocumentRepository;
        this.findCompanyByIdRepository = findCompanyByIdRepository;
        this.checkIfCepIsValidUsecase = checkIfCepIsValidUsecase;
    }

    public String checkCep(String cep, List<Supplier> suppliers) {
        String uf = checkIfCepIsValidUsecase.exec(cep);
        if(uf == null) {
            throw new InvalidCepException(String.format("The following CEP is invalid %s", cep));
        }

        if(!uf.equals("PR")) return uf;

        suppliers.forEach(supplier -> {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime birthDate = LocalDateTime.ofInstant(supplier.getBirthDate().toInstant(), ZoneId.systemDefault());
            long diff = ChronoUnit.YEARS.between(birthDate, now);
            if (diff < 18) throw new InvalidCepException("Invalid Cep. Companies from PR can't have under 18 years old CPF Suppliers");
        });

        return uf;
    }

    public Company execute(Company company) {
        Company companyExisted = findCompanyByIdRepository.findById(company.getId());
        if (companyExisted == null) {
            throw new NoRecordFoundException(String.format("Company with id %s not found", company.getId()));
        }
        Company companyDocumentAlreadyExisted = findByDocumentRepository.findByDocument(company.getDocument());
        if (companyDocumentAlreadyExisted != null && !Objects.equals(companyDocumentAlreadyExisted.getId(), company.getId())) {
            throw new AlreadyExistsException(String.format("Already exists a company with document %s", company.getDocument()));
        }
        String uf = checkCep(company.getCep(), companyExisted.getSuppliers());
        if(uf == null) {
            throw new InvalidCepException(String.format("The following CEP is invalid %s", company.getCep()));
        }
        Company companyToUpdate = new Company(company.getId(), company.getTradeName(),company.getDocument(), company.getCep(),uf, companyExisted.getSuppliers());
        return updateCompanyRepository.updateCompanyById(companyToUpdate);
    }
}
