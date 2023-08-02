package com.mak.api;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class Api {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping()
    public String index() {
        return "API V1 : " + appVersion;
        // throw new Exception("Some Exception");

    }

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("Hello Reactive Programming").log();

    }

    @GetMapping("/flux")
    public Flux<Integer> flux() {
        return Flux.just(1, 2, 3, 4)
                // .delayElements(Duration.ofSeconds(1))
                .log();

    }

    @GetMapping(value = "/flux-stream", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Integer> fluxStream() {
        return Flux.just(1, 2, 3, 4)
                .delayElements(Duration.ofSeconds(1))
                .log();

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
