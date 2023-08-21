package com.accenture.challenge.http.Company;

import com.accenture.challenge.application.usecases.company.ListCompaniesUsecase;
import com.accenture.challenge.utils.entities.Company;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class ListCompaniesController {
    private final ListCompaniesUsecase listCompaniesUsecase;

    public ListCompaniesController(ListCompaniesUsecase listCompaniesUsecase) {
        this.listCompaniesUsecase = listCompaniesUsecase;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Company> ListCompany(@RequestParam( value = "searchTerm", required = false) String searchTerm) {
        return listCompaniesUsecase.execute(searchTerm);
    }
}
