package com.accenture.challenge.http.Company;

import com.accenture.challenge.application.usecases.company.CreateCompanyUsecase;
import com.accenture.challenge.utils.entities.Company;
import com.accenture.challenge.utils.DTO.CreateCompanyRequestBodyParams;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CreateCompanyController {
    private final CreateCompanyUsecase createCompanyUsecase;

    public CreateCompanyController(CreateCompanyUsecase createCompanyUsecase) {
        this.createCompanyUsecase = createCompanyUsecase;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody @Valid CreateCompanyRequestBodyParams body) {
        return createCompanyUsecase.execute(body.company());
    }
}
