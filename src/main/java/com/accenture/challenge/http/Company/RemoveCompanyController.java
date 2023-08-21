package com.accenture.challenge.http.Company;

import com.accenture.challenge.application.usecases.company.interfaces.RemoveCompanyUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company/{id}")
public class RemoveCompanyController {
    private final RemoveCompanyUsecase removeCompanyUsecase;

    public RemoveCompanyController(RemoveCompanyUsecase removeCompanyUsecase) {
        this.removeCompanyUsecase = removeCompanyUsecase;
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public void removeCompany(@PathVariable long id) {
        removeCompanyUsecase.execute(id);
    }
}

