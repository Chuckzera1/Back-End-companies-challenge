package com.accenture.challenge.application.repositories.supplier;

import com.accenture.challenge.utils.entities.Supplier;

import java.util.List;

public interface ListWithFilterSuppliersRepository {
    List<Supplier> listWithFilter(String searchTerm);
}
