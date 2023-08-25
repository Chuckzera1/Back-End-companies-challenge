package com.accenture.challenge.application.usecases.supplier;

import com.accenture.challenge.application.repositories.company.FindCompanyByIdRepository;
import com.accenture.challenge.application.repositories.supplier.FindSupplierByIdRepository;
import com.accenture.challenge.application.repositories.supplier.RemoveSupplierRepository;
import com.accenture.challenge.application.usecases.supplier.interfaces.RemoveSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import com.accenture.challenge.utils.errors.NoRecordFoundException;
import org.springframework.stereotype.Service;

@Service
public class RemoveSupplierUsecaseImpl implements RemoveSupplierUsecase {

    private final RemoveSupplierRepository removeSupplierRepository;
    private final FindSupplierByIdRepository findSupplierByIdRepository;
    private final FindCompanyByIdRepository findCompanyByIdRepository;

    RemoveSupplierUsecaseImpl
            (RemoveSupplierRepository removeSupplierRepository, FindSupplierByIdRepository findSupplierByIdRepository, FindCompanyByIdRepository findCompanyByIdRepository) {
        this.removeSupplierRepository = removeSupplierRepository;
        this.findSupplierByIdRepository = findSupplierByIdRepository;
        this.findCompanyByIdRepository = findCompanyByIdRepository;
    }

    ;

    public void exec(Long id) {
        Supplier supplier = findSupplierByIdRepository.findById(id);
        if (supplier == null) throw new NoRecordFoundException("Supplier with id " + id + "Not Found");

        removeSupplierRepository.remove(id);
    }
}
