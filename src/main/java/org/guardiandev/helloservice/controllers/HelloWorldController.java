package org.guardiandev.helloservice.controllers;

import org.guardiandev.helloservice.api.HelloApi;
import org.guardiandev.helloservice.service.HelloService;
import org.guardiandev.helloservice.models.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController implements HelloApi {

    private final HelloService helloService;

    public HelloWorldController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Mono<ResponseEntity<Hello>> hello(ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(helloService.getHello(), HttpStatus.OK));
    }
}
