package com.accenture.challenge.http.Supplier;

import com.accenture.challenge.application.usecases.supplier.interfaces.CreateSupplierUsecase;
import com.accenture.challenge.utils.DTO.CreateSupplierRequestBodyParams;
import com.accenture.challenge.utils.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class CreateSuppliersController {
    private final CreateSupplierUsecase createSupplierUsecase;

    public CreateSuppliersController(CreateSupplierUsecase createSupplierUsecase) {
        this.createSupplierUsecase = createSupplierUsecase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier createSupplier(@RequestBody @Valid CreateSupplierRequestBodyParams body) {
        return createSupplierUsecase.execute(body.supplier());
    }
}