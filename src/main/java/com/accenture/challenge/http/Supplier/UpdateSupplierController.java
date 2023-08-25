package com.accenture.challenge.http.Supplier;

import com.accenture.challenge.application.usecases.supplier.interfaces.UpdateSupplierUsecase;
import com.accenture.challenge.utils.DTO.CreateSupplierRequestBodyParams;
import com.accenture.challenge.utils.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier/{id}")
public class UpdateSupplierController {
    private final UpdateSupplierUsecase updateSupplierUsecase;

    public UpdateSupplierController(UpdateSupplierUsecase updateSupplierUsecase) {
        this.updateSupplierUsecase = updateSupplierUsecase;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Supplier updateSupplier(@PathVariable long id, @RequestBody @Valid CreateSupplierRequestBodyParams body) {
        Supplier supplier = new Supplier(id, body.getName(), body.getEmail(), body.getDocument(), body.getDocumentType(), body.getRg(), body.getCep(), body.getBirthDate());
        return updateSupplierUsecase.execute(supplier);
    }
}
