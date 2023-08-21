package com.accenture.challenge.http.Company;

import com.accenture.challenge.application.usecases.company.interfaces.UpdateCompanyUsecase;
import com.accenture.challenge.utils.DTO.CreateCompanyRequestBodyParams;
import com.accenture.challenge.utils.entities.Company;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/{id}")
public class UpdateCompanyController {
    private final UpdateCompanyUsecase updateCompanyUsecase;

    public UpdateCompanyController(UpdateCompanyUsecase updateCompanyUsecase) {
        this.updateCompanyUsecase = updateCompanyUsecase;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@PathVariable long id, @RequestBody @Valid CreateCompanyRequestBodyParams body) {
        Company company = new Company(id, body.getTradeName(), body.getDocument(), body.getCep());
        return updateCompanyUsecase.execute(company);
    }
}
