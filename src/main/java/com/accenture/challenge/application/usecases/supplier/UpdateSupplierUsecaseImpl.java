package com.accenture.challenge.application.usecases.supplier;

import com.accenture.challenge.application.repositories.supplier.FindSupplierByDocumentRepository;
import com.accenture.challenge.application.repositories.supplier.FindSupplierByIdRepository;
import com.accenture.challenge.application.repositories.supplier.UpdateSupplierRepository;
import com.accenture.challenge.application.usecases.CheckIfCepIsValidUsecase;
import com.accenture.challenge.application.usecases.supplier.interfaces.UpdateSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.InvalidCepException;
import com.accenture.challenge.utils.errors.NoRecordFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateSupplierUsecaseImpl implements UpdateSupplierUsecase {

    private final UpdateSupplierRepository updateSupplierRepository;

    private final FindSupplierByDocumentRepository findByDocumentRepository;
    private final FindSupplierByIdRepository findSupplierByIdRepository;

    private final CheckIfCepIsValidUsecase checkIfCepIsValidUsecase;

    public UpdateSupplierUsecaseImpl(
            UpdateSupplierRepository updateSupplierRepository,
            FindSupplierByDocumentRepository findByDocumentRepository,
            FindSupplierByIdRepository findSupplierByIdRepository,
            CheckIfCepIsValidUsecase checkIfCepIsValidUsecase) {
        this.updateSupplierRepository = updateSupplierRepository;
        this.findByDocumentRepository = findByDocumentRepository;
        this.findSupplierByIdRepository = findSupplierByIdRepository;
        this.checkIfCepIsValidUsecase = checkIfCepIsValidUsecase;
    }

    public Supplier execute(Supplier supplier) {
        Supplier supplierExisted = findSupplierByIdRepository.findById(supplier.getId());
        if (supplierExisted == null) {
            throw new NoRecordFoundException(String.format("Supplier with id %s not found", supplier.getId()));
        }
        Supplier SupplierDocumentAlreadyExisted = findByDocumentRepository.findByDocument(supplier.getDocument());
        if (SupplierDocumentAlreadyExisted != null && !Objects.equals(SupplierDocumentAlreadyExisted.getId(), supplier.getId())) {
            throw new AlreadyExistsException(String.format("Already exists a Supplier with document %s", supplier.getDocument()));
        }
       String uf = checkIfCepIsValidUsecase.exec(supplier.getCep());
        if(uf == null) {
            throw new InvalidCepException(String.format("The following CEP is invalid %s", supplier.getCep()));
        }
        Supplier supplierToUpdate = new Supplier(supplier.getId(), supplier.getName(), supplier.getEmail(), supplier.getDocument(), supplier.getDocumentType(), supplier.getRg(), supplier.getCep(), supplier.getBirthDate(), supplierExisted.getCompanies());
        return updateSupplierRepository.updateSupplierById(supplierToUpdate);
    }
}
