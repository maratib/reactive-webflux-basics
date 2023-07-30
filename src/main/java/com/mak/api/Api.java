package com.mak.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class Api {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping()
    public String index() throws Exception {
        return "API V1 : " + appVersion;
        // throw new Exception("Some Exception");
        

    }

    private void getValue(Mono<String> monoString) {

        monoString.subscribe(System.out::print);

    }

    // @GetMapping("/path-variable/{first}/{second}")
    // public String pathVariable(@PathVariable String first, @PathVariable String
    // second) {

    // return String.format("API : First:%s Second:%s ", first, second);
    // }

    // @GetMapping("/request-param")
    // public String requestParam(@RequestParam String first,
    // @RequestParam(required = false, defaultValue = "abc") String second) {

    // return String.format("API : First:%s Second:%s ", first, second);
    // }

    // @PostMapping("/post-validate")
    // public String authenticateAndGetToken(@RequestBody @Valid AuthRequest
    // authRequest) {
    // // System.out.println("Auth : " + authRequest);

    // return "Hello Post : " + authRequest;
    // }

}
