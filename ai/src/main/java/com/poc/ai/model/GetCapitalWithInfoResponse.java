package com.poc.ai.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalWithInfoResponse(@JsonPropertyDescription("This property is to define the capital field") String capital,
                                         @JsonPropertyDescription("This property is to define the population field") String population,
                                         @JsonPropertyDescription("This property is to define the notableFeature field") String notableFeature,
                                         @JsonPropertyDescription("This property is to define the foundingYear field") String foundingYear,
                                         @JsonPropertyDescription("This property is to define the primaryLanguage field") String primaryLanguage) {
}
