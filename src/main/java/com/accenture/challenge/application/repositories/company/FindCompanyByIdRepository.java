package com.accenture.challenge.application.repositories.company;

import com.accenture.challenge.utils.entities.Company;

public interface FindCompanyByIdRepository {
    Company findById(Long id);
}
