package com.poc.ai.controllers;


import com.poc.ai.model.Answer;
import com.poc.ai.model.GetCapitalRequest;
import com.poc.ai.model.GetCapitalResponse;
import com.poc.ai.model.Questions;
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
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest request){
        return openAIService.getCapitalWithInfo(request);
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
