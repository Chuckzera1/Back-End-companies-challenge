package com.accenture.challenge.application.usecases.supplier;

import com.accenture.challenge.application.repositories.supplier.CreateSupplierRepository;
import com.accenture.challenge.application.usecases.supplier.interfaces.CreateSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierUsecaseImpl implements CreateSupplierUsecase {
    private final CreateSupplierRepository createSupplierRepository;

    public CreateSupplierUsecaseImpl(CreateSupplierRepository createSupplierRepository) {
        this.createSupplierRepository = createSupplierRepository;
    }

    public Supplier execute(Supplier supplier) {
        return createSupplierRepository.create(supplier);
    }
}
