package com.poc.ai.services;

import com.poc.ai.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService{

    private final ChatModel chatModel;
    private final SimpleVectorStore vectorStore;

    @Value("classpath:templates/get-prompt-statements.st")
    private Resource getPromptStatements;

    @Value("classpath:templates/get-capital-with-info.st")
    private Resource getCapitalWithInfoPrompt;

    @Value("classpath:templates/rag-prompt-template-meta.st")
    private Resource ragPromptTemplate;


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
        PromptTemplate promptTemplate = new PromptTemplate(getPromptStatements);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", request.stateOrCountry(),
                "format", format));

        ChatResponse response = chatModel.call(prompt);

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

        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder().query(question.question()).topK(11).build());

        List<String> contentsList = documents.stream().map(Document::getFormattedContent).toList();

        PromptTemplate template = new PromptTemplate(ragPromptTemplate);
        Prompt prompt = template.create(Map.of("input", question.question(),
                "documents", String.join("\n", contentsList)));

        contentsList.forEach(System.out::println);

        ChatResponse response = chatModel.call(prompt);

        return new Answer(response.getResult().getOutput().getText());
    }
}
