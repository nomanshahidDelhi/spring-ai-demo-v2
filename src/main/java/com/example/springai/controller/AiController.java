package com.example.springai.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatModel chatModel;

    public AiController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        ChatResponse response = chatModel.call(question);
        return response.getResult().getOutput().getContent();
    }
}
