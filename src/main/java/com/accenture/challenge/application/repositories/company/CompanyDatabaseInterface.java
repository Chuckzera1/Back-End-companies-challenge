package com.accenture.challenge.application.repositories.company;

import com.accenture.challenge.infra.models.company.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyDatabaseInterface extends JpaRepository<CompanyModel, Long> {
    Optional<CompanyModel> findByDocument(String document);
}
