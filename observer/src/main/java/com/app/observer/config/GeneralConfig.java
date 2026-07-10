package com.app.observer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GeneralConfig {

    @Bean
    public RestClient restClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder
                .baseUrl("http://observer2:8081/server-2")
            .build();
    }


    /*@Bean(name = "jsonplaceholder")
    public RestClient restClientUser(){
        return RestClient.builder()
                .baseUrl("http://localhost:8081/server-2")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
                })
                .requestInterceptors( interceptors -> {
                    interceptors.add(loggingInterceptor());
                })
                .build();
    }


    private ClientHttpRequestInterceptor loggingInterceptor() {
        return (request, body, execution) -> {

            request.getHeaders().forEach((k, v) ->
                    System.out.println(k + " = " + v));

            return execution.execute(request, body);
        };
    }*/
}
