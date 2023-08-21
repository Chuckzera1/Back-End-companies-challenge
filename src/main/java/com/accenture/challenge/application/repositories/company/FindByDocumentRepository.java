package com.accenture.challenge.application.repositories.company;

import com.accenture.challenge.utils.entities.Company;

public interface FindByDocumentRepository {
    Company findByDocument(String document);
}
