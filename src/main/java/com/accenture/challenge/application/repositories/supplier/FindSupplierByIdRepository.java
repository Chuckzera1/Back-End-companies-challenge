package com.accenture.challenge.application.repositories.supplier;

import com.accenture.challenge.utils.entities.Supplier;

public interface FindSupplierByIdRepository {
    Supplier findById(Long id);
}
