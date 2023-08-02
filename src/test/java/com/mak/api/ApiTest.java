package com.mak.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = Api.class)
// @WebFluxTest
public class ApiTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void Test1() {
        client.get()
                .uri("/api/v1/flux")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk();
        System.out.println("Test 1");
    }

}
