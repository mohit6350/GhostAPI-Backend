package com.ghostAPI.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class WiremockPostStubGenerator {

    public String generatePostStubJson(String requestBody) {
        // Convert the provided JSON payload to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to JSON", e);
        }

        // Use the generated JSON to create a WireMock stub
        String wireMockStub = generateWireMockStub(json);

        return wireMockStub;
    }

    private static String generateWireMockStub(String responseBody) {
        // Corrected method to generate the complete WireMock stub JSON
        // Surround the %s placeholder with double quotes
        return String.format("{ \"response\": { \"status\": 200, \"jsonBody\": \"%s\" } }", responseBody);
    }
}
