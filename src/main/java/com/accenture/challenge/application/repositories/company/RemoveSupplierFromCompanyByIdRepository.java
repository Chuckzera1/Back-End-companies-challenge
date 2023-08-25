package com.accenture.challenge.application.repositories.company;

import com.accenture.challenge.utils.entities.Company;

public interface RemoveSupplierFromCompanyByIdRepository {
    Company removeSupplier(Long companyId, Long supplierId);
}
