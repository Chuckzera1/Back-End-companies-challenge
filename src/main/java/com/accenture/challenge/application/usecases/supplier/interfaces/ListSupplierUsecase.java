package com.accenture.challenge.application.usecases.supplier.interfaces;

import com.accenture.challenge.utils.entities.Supplier;

import java.util.List;

public interface ListSupplierUsecase {
    List<Supplier> execute(String searchTerm);
}
