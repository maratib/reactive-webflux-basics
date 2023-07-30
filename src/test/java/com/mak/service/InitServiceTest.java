package com.mak.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InitServiceTest {

    @Autowired
    private InitService initService;

    @Test
    void test1() {

        // initService.doTest();
        int[] numbers = new int[] { 1, 2, 3, 4 };
        int result = 0;
        for (int number : numbers) {
            result *= number;
        }

        System.out.println(result);

    }

}
