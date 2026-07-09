package com.app.observer.service;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.observation.annotation.ObservationKeyValue;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ServiceRandomImpl implements ServiceRandom{

    private final RestClient restClient;

    @Autowired
    public ServiceRandomImpl(RestClient restClient){
        this.restClient = restClient;
    }

    @Override
    public String getNumberRandom() {
        return String.valueOf(ThreadLocalRandom.current()
                .nextInt(1, 1500));
    }

    @Observed
    @Override
    public String getUserById(@ObservationKeyValue(key = "user.id") long id) {
        String data = this.restClient
                .get()
                .uri("/user/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) ->{
                    System.out.println("Error 400: " + req.getURI().toString());
                }).onStatus(HttpStatusCode::is5xxServerError, (req, res)-> {
                    System.out.println("Error 500");
                }).body(String.class);
        return data;
    }
}
