package com.tp.tonep;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

@Service
public class TonePolishService {

    @Value("${ai.api.key}")
    private String apikey;

    @Value("${ai.api.url}")
    private String apiUrl;

    public String refineText(String text) {
        WebClient webClient = WebClient.create(apiUrl);

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be empty");
        }

        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.1-8b-instant",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content",
                                "Change the tone of the given text to a professional and empathetic one, correcting any grammar and spelling mistakes don't say anything else just reply with the corrected text:\n"
                                        + text)));
        try {
            Map<String, Object> response = webClient.post()
                    .header(HttpHeaders.AUTHORIZATION,
                            "Bearer " + apikey)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
            return ((Map<String, String>) choices.get(0).get("message")).get("content");
        } catch (Exception e) {
            throw new RuntimeException("Failed to Refine");
        }
    }
}
