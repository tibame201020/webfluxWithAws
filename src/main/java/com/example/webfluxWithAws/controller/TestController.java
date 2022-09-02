package com.example.webfluxWithAws.controller;

import com.example.webfluxWithAws.domain.AWSDb;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @RequestMapping("/hello/{jsonData}")
    public Mono<AWSDb> hello(@PathVariable("jsonData") String jsonData) {

        return Mono.just(new AWSDb("dala", jsonData));
    }
}
