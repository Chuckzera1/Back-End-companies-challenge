package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.FindCompanyByIdRepository;
import com.accenture.challenge.application.repositories.company.RelateSupplierToCompanyByIdRepository;
import com.accenture.challenge.application.repositories.supplier.FindSupplierByIdRepository;
import com.accenture.challenge.application.usecases.company.interfaces.RelateSuppliersToCompanyByIdUsecase;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.entities.Supplier;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.InvalidCepException;
import com.accenture.challenge.utils.errors.NoRecordFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

@Service
public class RelateSuppliersToCompanyByIdUsecaseImpl implements RelateSuppliersToCompanyByIdUsecase {
    private final RelateSupplierToCompanyByIdRepository relateSupplierToCompanyByIdRepository;
    private final FindCompanyByIdRepository findCompanyByIdRepository;

    private final FindSupplierByIdRepository findSupplierByIdRepository;

    public RelateSuppliersToCompanyByIdUsecaseImpl(RelateSupplierToCompanyByIdRepository relateSupplierToCompanyByIdRepository, FindCompanyByIdRepository findCompanyByIdRepository, FindSupplierByIdRepository findSupplierByIdRepository) {
        this.relateSupplierToCompanyByIdRepository = relateSupplierToCompanyByIdRepository;
        this.findCompanyByIdRepository = findCompanyByIdRepository;
        this.findSupplierByIdRepository = findSupplierByIdRepository;
    }

    private void getDiffInYears(Date supplierBirthDate) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthDate = LocalDateTime.ofInstant(supplierBirthDate.toInstant(), ZoneId.systemDefault());
        long diff = ChronoUnit.YEARS.between(birthDate , now);
        if (diff < 18) throw new InvalidCepException("Company from PR cannot hire Suppliers under 18 years old.");
    }

    public void checkIfUserAlreadyHasRelation(Company company, Long supplierId){
        for(Supplier sup: company.getSuppliers()){
            if(Objects.equals(sup.getId(), supplierId)) throw new AlreadyExistsException("This Supplier is already related. Id: "+supplierId);
        }
    }


    public Company exec(Long companyId, Long supplierId) {
        Company companyToRelate = findCompanyByIdRepository.findById(companyId);
        if (companyToRelate == null)
            throw new NoRecordFoundException(String.format("Company with id %s Not Found", companyId));
        checkIfUserAlreadyHasRelation(companyToRelate, supplierId);
        Supplier supplierToRelate = findSupplierByIdRepository.findById(supplierId);
        if (supplierToRelate == null)
            throw new NoRecordFoundException(String.format("Supplier with id %s Not Found", supplierId));

        if (Objects.equals(companyToRelate.getStateUf(), "PR") && Objects.equals(supplierToRelate.getDocumentType(), "CPF"))
            getDiffInYears(supplierToRelate.getBirthDate());

        companyToRelate.AddSupplier(supplierToRelate);

        return relateSupplierToCompanyByIdRepository.relateSupplier(companyToRelate);
    }

}
