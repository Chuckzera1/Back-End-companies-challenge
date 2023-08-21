package com.accenture.challenge.application.usecases.company;

import com.accenture.challenge.application.repositories.company.RemoveCompanyRepository;
import com.accenture.challenge.application.usecases.company.interfaces.RemoveCompanyUsecase;
import org.springframework.stereotype.Service;

@Service
public class RemoveCompanyUsecaseImpl implements RemoveCompanyUsecase {
    private final RemoveCompanyRepository removeCompanyRepository;

    public RemoveCompanyUsecaseImpl(RemoveCompanyRepository removeCompanyRepository) {
        this.removeCompanyRepository = removeCompanyRepository;
    }

    public void execute(Long id){
        removeCompanyRepository.remove(id);
        return ;
    }

}
