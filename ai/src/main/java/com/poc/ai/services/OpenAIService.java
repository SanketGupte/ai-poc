package com.poc.ai.services;

import com.poc.ai.model.Answer;
import com.poc.ai.model.GetCapitalRequest;
import com.poc.ai.model.GetCapitalResponse;
import com.poc.ai.model.Questions;

public interface OpenAIService{

    Answer getCapitalWithInfo(GetCapitalRequest request);

    GetCapitalResponse getCapital(GetCapitalRequest request);

    String getAnswer(String question);

    Answer getAnswer(Questions question);
}
