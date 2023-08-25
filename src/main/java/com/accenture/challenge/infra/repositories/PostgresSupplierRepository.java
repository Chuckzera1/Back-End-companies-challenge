package com.accenture.challenge.infra.repositories;

import com.accenture.challenge.application.repositories.supplier.*;
import com.accenture.challenge.infra.models.company.SupplierModel;
import com.accenture.challenge.utils.entities.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostgresSupplierRepository implements ListSupplierRepository,
        CreateSupplierRepository,
        ListWithFilterSuppliersRepository,
        RemoveSupplierRepository,
        UpdateSupplierRepository,
        FindSupplierByDocumentRepository,
        FindSupplierByIdRepository {
    private final SupplierDatabaseInterface supplierDatabase;

    public PostgresSupplierRepository(SupplierDatabaseInterface supplierDatabase) {
        this.supplierDatabase = supplierDatabase;
    }

    public Supplier create(Supplier supplier) { return supplierDatabase.save(new SupplierModel(supplier)).toSupplier(); }

    public List<Supplier> list() {
        return supplierDatabase.findAll().stream().map(SupplierModel::toSupplier).collect(Collectors.toList());
    }

    public List<Supplier> listWithFilter(String searchTerm) {
        return supplierDatabase.findByDocumentOrName(searchTerm, searchTerm).stream().map(SupplierModel::toSupplier).collect(Collectors.toList());
    }

    public Supplier findByDocument(String document){
        return supplierDatabase.findByDocument(document).map(SupplierModel::toSupplier).orElse(null);
    }

    public void remove(long id) {
        supplierDatabase.deleteById(id);
    }

    public Supplier updateSupplierById(Supplier supplier) {
        return supplierDatabase.save(new SupplierModel(supplier)).toSupplier();
    }

    public Supplier findById(Long id) {
        return supplierDatabase.findById(id).map(SupplierModel::toSupplier).orElse(null);
    }

}
