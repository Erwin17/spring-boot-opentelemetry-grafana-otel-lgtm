package com.app.observer2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class ConfigApp {

    @Bean
    public RestClient restClient(RestClient.Builder restClient){
        return restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeaders( httpHeaders -> {
                    httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
                    httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                }).build();
    }
}
