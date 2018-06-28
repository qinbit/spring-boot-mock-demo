package com.pnshsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {

    private RestTemplate restTemplate;

    @Autowired
    public RestServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public String query() {
        return restTemplate.getForObject("http://localhost:8081/hello", String.class);
    }
}
