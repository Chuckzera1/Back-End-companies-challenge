package com.accenture.challenge.application.usecases;

import com.accenture.challenge.infra.cepla.Address;
import com.accenture.challenge.infra.cepla.api.GetAddressByCepApi;
import org.springframework.stereotype.Service;

@Service
public class CheckIfCepIsValidImpl implements CheckIfCepIsValidUsecase {
    private final GetAddressByCepApi getAddressByCepApi;

    public CheckIfCepIsValidImpl (GetAddressByCepApi getAddressByCepApi){
        this.getAddressByCepApi = getAddressByCepApi;
    }

    public String exec(String cep){
        try {
            Address address = getAddressByCepApi.getAddressByCep(cep).getBody();
            assert address != null;

            return address.getUf();
        }
        catch (Exception e) {
            return null;
        }
    }
}
