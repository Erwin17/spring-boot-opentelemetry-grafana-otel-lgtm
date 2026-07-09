package com.app.observer.controller;

import com.app.observer.service.ServiceRandom;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/server-1")
@AllArgsConstructor
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final ServiceRandom serviceRandom;

    @GetMapping(value = "/random")
    public String random(){
        return serviceRandom.getNumberRandom();
    }

    @GetMapping(value="/random/{id}")
    public String randomV2(
            @PathVariable(value = "id") int id) throws InterruptedException{

        Thread.sleep(3000);
        return "Numero Ingresado: " + id;
    }

    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable("id") long id){
        log.info("Se llamo a getUser: {}", id);
        return this.serviceRandom.getUserById(id);
    }
}
