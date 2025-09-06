package com.poc.ai.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    OpenAIServiceImpl openAIService;

    @Test
    void getAnswer() {
        String answer = openAIService.getAnswer("Generate my horoscope based on my " +
                "birth date: 1994-02-16, birth time: 09:37 am and " +
                "birth place: Nagpur, Maharashtra, India");

        System.out.println(answer);
    }
}