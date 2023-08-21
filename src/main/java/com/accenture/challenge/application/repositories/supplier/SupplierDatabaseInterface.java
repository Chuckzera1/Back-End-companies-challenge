package com.accenture.challenge.application.repositories.supplier;

import com.accenture.challenge.infra.models.company.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierDatabaseInterface extends JpaRepository<SupplierModel, Long> {
    Optional<SupplierModel> findByDocument(String document);
    List<SupplierModel> findByDocumentOrName(String document, String name);
}
