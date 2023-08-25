package com.accenture.challenge.http.Supplier;

import com.accenture.challenge.application.usecases.supplier.interfaces.RemoveSupplierUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier/{id}")
public class RemoveSupplierController {
    private final RemoveSupplierUsecase removeSupplierUsecase;

    public RemoveSupplierController(RemoveSupplierUsecase removeSupplierUsecase) {
        this.removeSupplierUsecase = removeSupplierUsecase;
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public void removeCompany(@PathVariable long id) {
        removeSupplierUsecase.exec(id);
    }
}
