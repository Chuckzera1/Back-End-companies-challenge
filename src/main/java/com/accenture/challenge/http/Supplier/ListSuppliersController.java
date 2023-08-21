package com.accenture.challenge.http.Supplier;

import com.accenture.challenge.application.usecases.supplier.interfaces.ListSupplierUsecase;
import com.accenture.challenge.utils.entities.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class ListSuppliersController {
    private final ListSupplierUsecase listSupplierUsecase;

    public ListSuppliersController(ListSupplierUsecase listSupplierUsecase) {
        this.listSupplierUsecase = listSupplierUsecase;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Supplier> listSupplier(@RequestParam( value = "searchTerm", required = false) String searchTerm) {
        return listSupplierUsecase.execute(searchTerm);
    }
}
