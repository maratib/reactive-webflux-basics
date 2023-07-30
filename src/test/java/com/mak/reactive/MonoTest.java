package com.mak.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

    @Test
    public void monoTest() {
        Mono<String> stringMono = Mono.just("Spring");
        // stringMono.subscribe(System.out::println);
        StepVerifier.create(stringMono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    public void monoTest_Error() {

        StepVerifier.create(Mono.error(new RuntimeException("Exception Occurred")).log())
                .expectErrorMessage("Exception Occurred")
                .verify();
    }
}
