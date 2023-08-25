package com.accenture.challenge.application.repositories.company;

import com.accenture.challenge.utils.entities.Company;

public interface RelateSupplierToCompanyByIdRepository {
    Company relateSupplier(Company company);
}
