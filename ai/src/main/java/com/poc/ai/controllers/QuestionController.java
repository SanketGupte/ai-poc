package com.poc.ai.controllers;


import com.poc.ai.model.*;
import com.poc.ai.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/capitalWithInfo")
    public GetCapitalWithInfoResponse getCapitalWithInfo(@RequestBody GetCapitalRequest request){
        return this.openAIService.getCapitalWithInfo(request);
    }

    @PostMapping("/capital")
    public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest request){
        return this.openAIService.getCapital(request);
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Questions questions){
        return openAIService.getAnswer(questions);
    }
}
