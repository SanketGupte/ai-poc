package com.poc.ai.services;

import com.poc.ai.model.*;

public interface OpenAIService{

    GetCapitalWithInfoResponse getCapitalWithInfo(GetCapitalRequest request);

    GetCapitalResponse getCapital(GetCapitalRequest request);

    String getAnswer(String question);

    Answer getAnswer(Questions question);
}
