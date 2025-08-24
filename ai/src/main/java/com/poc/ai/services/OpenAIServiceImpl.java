package com.poc.ai.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.ai.model.*;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OpenAIServiceImpl implements OpenAIService{

    private final ChatModel chatModel;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Value("classpath:templates/get-prompt-statements.st")
    private Resource getPromptStatements;

    @Value("classpath:templates/get-capital-with-info.st")
    private Resource getCapitalWithInfoPrompt;

//    @Autowired
//    ObjectMapper objectMapper;

    @Override
    public GetCapitalWithInfoResponse getCapitalWithInfo(GetCapitalRequest request){

        BeanOutputConverter<GetCapitalWithInfoResponse> converter = new BeanOutputConverter<>(GetCapitalWithInfoResponse.class);
        String format = converter.getFormat();

        PromptTemplate promptTemplate = new PromptTemplate(getCapitalWithInfoPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", request.stateOrCountry(),
                "format", format));

        ChatResponse response = chatModel.call(prompt);

        return converter.convert(Objects.requireNonNull(response.getResult().getOutput().getText()));
    }

    @Override
    public GetCapitalResponse getCapital(GetCapitalRequest request) {

        BeanOutputConverter<GetCapitalResponse> converter = new BeanOutputConverter<>(GetCapitalResponse.class);
        String format = converter.getFormat();
//        System.out.println("format: \n" + format);
//        PromptTemplate promptTemplate = new PromptTemplate("What is the capital of" + request.stateOrCountry() + "?");
        PromptTemplate promptTemplate = new PromptTemplate(getPromptStatements);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", request.stateOrCountry(),
                "format", format));

        ChatResponse response = chatModel.call(prompt);

//        System.out.println(response.getResult().getOutput().getText());
//        String responseString;
//
//        try{
//            JsonNode jsonNode = objectMapper.readTree(response.getResult().getOutput().getText());
//            responseString = jsonNode.get("answer").asText();
//        }catch (JsonProcessingException e){
//            throw new RuntimeException(e);
//        }

        return converter.convert(Objects.requireNonNull(response.getResult().getOutput().getText()));
    }

    @Override
    public String getAnswer(String question) {

        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatModel.call(prompt);


        return response.getResult().getOutput().getText();
    }

    @Override
    public Answer getAnswer(Questions question){
        PromptTemplate template = new PromptTemplate(question.question());
        Prompt prompt = template.create();
        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getText());
    }
}
