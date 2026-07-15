package com.app.observer2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping(value = "/server-2")
public class HomeController {

    private final RestClient restClient;

    @Autowired
    public HomeController(RestClient restClient){
        this.restClient = restClient;
    }

    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable("id") long id,
                              @RequestHeader HttpHeaders headers){

        headers.forEach((name, value)->{
            System.out.println("Name: " + name + " Value: " + value);
        });

        return this.restClient.get().uri("/users/{id}", id)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
            System.out.println("Error en la llamada al serviocio: " + response.getStatusCode());
            throw  new IllegalStateException("Error peticion: 400");
        })
        .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
            System.out.println("Error interno en el servicio");
            throw new IllegalStateException("Error interno en el servidor: "  + response.getStatusCode());
        })
        .body(String.class);
    }

}
