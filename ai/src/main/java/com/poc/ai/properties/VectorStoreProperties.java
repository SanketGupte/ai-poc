package com.poc.ai.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.poc.ai")
public class VectorStoreProperties {

    private String vectorStorePath;

    public String getVectorStorePath() {
        return vectorStorePath;
    }

    public void setVectorStorePath(String vectorStorePath) {
        this.vectorStorePath = vectorStorePath;
    }
}
