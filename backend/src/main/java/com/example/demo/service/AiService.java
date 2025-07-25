package com.example.demo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ChatMessage;
import com.example.demo.dto.ChatRequest;
import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepo;
@Service
public class AiService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    HttpHeaders headers;

    public String getAiAssistance(Task task) {
        String taskDescription = task.getDescription();


        String apiUrl = "https://api.openai.com/v1/chat/completions";

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("sike-nigga-you-thought");

        ChatMessage systemMsg = new ChatMessage("system", "You are a helpful assistant.");
        ChatMessage userMsg = new ChatMessage("user", "How do I do this task: " + taskDescription);

        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("gpt-4o-mini");
        chatRequest.setMessages(List.of(systemMsg, userMsg));

        HttpEntity<ChatRequest> entity = new HttpEntity<>(chatRequest, headers);

        var response = restTemplate.postForEntity(apiUrl, entity, Map.class);

        Map<String, Object> body = response.getBody();
        if (body == null) return "No response from OpenAI";

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> choices = (List<Map<String, Object>>) body.get("choices");
        Map<String, Object> firstChoice = choices.get(0);
        @SuppressWarnings("unchecked")
        Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");

        return (String) message.get("content");
    }
}
