package com.accenture.challenge.infra.cepla.api;

import com.accenture.challenge.infra.cepla.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Repository
public class GetAddressByCepApi {
    private @Value("${cep.la.baseUri}") String cepLaBaseUri;
    private final RestTemplate restTemplate;

    public GetAddressByCepApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public ResponseEntity<Address> getAddressByCep(String cep) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> request = new HttpEntity<>(headers);
        return this.restTemplate.exchange(this.cepLaBaseUri + '/' + cep, HttpMethod.GET,request, Address.class, 1);
    };

}
