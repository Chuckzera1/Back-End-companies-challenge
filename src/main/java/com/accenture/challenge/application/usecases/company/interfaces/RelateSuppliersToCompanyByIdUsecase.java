package com.accenture.challenge.application.usecases.company.interfaces;

import com.accenture.challenge.utils.entities.Company;

public interface RelateSuppliersToCompanyByIdUsecase {
    Company exec(Long companyId, Long supplierId);
}
