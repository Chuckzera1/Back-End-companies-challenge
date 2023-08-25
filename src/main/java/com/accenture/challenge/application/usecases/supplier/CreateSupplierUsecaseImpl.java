package com.accenture.challenge.application.usecases.supplier;

import com.accenture.challenge.application.repositories.supplier.CreateSupplierRepository;
import com.accenture.challenge.application.repositories.supplier.FindSupplierByDocumentRepository;
import com.accenture.challenge.application.repositories.supplier.FindSupplierByIdRepository;
import com.accenture.challenge.application.usecases.CheckIfCepIsValidUsecase;
import com.accenture.challenge.application.usecases.supplier.interfaces.CreateSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import com.accenture.challenge.utils.errors.AlreadyExistsException;
import com.accenture.challenge.utils.errors.InvalidCepException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateSupplierUsecaseImpl implements CreateSupplierUsecase {
    private final FindSupplierByDocumentRepository findByDocumentRepository;

    private final FindSupplierByIdRepository findSupplierByIdRepository;

    private final CreateSupplierRepository createSupplierRepository;
    private final CheckIfCepIsValidUsecase checkIfCepIsValidUsecase;

    public CreateSupplierUsecaseImpl(CreateSupplierRepository createSupplierRepository, CheckIfCepIsValidUsecase checkIfCepIsValidUsecase, FindSupplierByIdRepository findSupplierByIdRepository, FindSupplierByDocumentRepository findByDocumentRepository) {
        this.createSupplierRepository = createSupplierRepository;
        this.checkIfCepIsValidUsecase = checkIfCepIsValidUsecase;
        this.findSupplierByIdRepository = findSupplierByIdRepository;
        this.findByDocumentRepository = findByDocumentRepository;
    }

    public Supplier execute(Supplier supplier) {
        Supplier SupplierDocumentAlreadyExisted = findByDocumentRepository.findByDocument(supplier.getDocument());
        if (SupplierDocumentAlreadyExisted != null && !Objects.equals(SupplierDocumentAlreadyExisted.getId(), supplier.getId())) {
            throw new AlreadyExistsException(String.format("Already exists a Supplier with document %s", supplier.getDocument()));
        }
        String uf = checkIfCepIsValidUsecase.exec(supplier.getCep());
        if(uf == null) {
            throw new InvalidCepException(String.format("The following CEP is invalid %s", supplier.getCep()));
        }
        return createSupplierRepository.create(supplier);
    }
}
