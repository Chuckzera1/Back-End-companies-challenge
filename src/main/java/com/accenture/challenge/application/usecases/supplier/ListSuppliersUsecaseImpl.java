package com.accenture.challenge.application.usecases.supplier;

import com.accenture.challenge.application.repositories.supplier.ListSupplierRepository;
import com.accenture.challenge.application.repositories.supplier.ListWithFilterSuppliersRepository;
import com.accenture.challenge.application.usecases.supplier.interfaces.ListSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSuppliersUsecaseImpl implements ListSupplierUsecase {
    private final ListSupplierRepository listSupplierRepository;
    private final ListWithFilterSuppliersRepository listWithFilterSuppliersRepository;

    public ListSuppliersUsecaseImpl(ListSupplierRepository listSupplierRepository, ListWithFilterSuppliersRepository listWithFilterSuppliersRepository) {
        this.listSupplierRepository = listSupplierRepository;
        this.listWithFilterSuppliersRepository = listWithFilterSuppliersRepository;
    }

    public List<Supplier> execute(String searchTerm) {
        if (searchTerm != null) {
            return listWithFilterSuppliersRepository.listWithFilter(searchTerm);
        }
        return listSupplierRepository.list();
    }
}