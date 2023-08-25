package com.accenture.challenge.http.Company;

import com.accenture.challenge.application.usecases.company.interfaces.RelateSuppliersToCompanyByIdUsecase;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/{companyId}/relateSupplier/{supplierId}")
public class RelateSuppliersToCompanyByIdController {

    private final RelateSuppliersToCompanyByIdUsecase relateSuppliersToCompanyByIdUsecase;

    public RelateSuppliersToCompanyByIdController(RelateSuppliersToCompanyByIdUsecase relateSuppliersToCompanyByIdUsecase) {
        this.relateSuppliersToCompanyByIdUsecase = relateSuppliersToCompanyByIdUsecase;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@PathVariable long companyId, @PathVariable long supplierId) {
        return relateSuppliersToCompanyByIdUsecase.exec(companyId, supplierId);
    }
}
