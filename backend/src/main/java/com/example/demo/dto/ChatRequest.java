package com.example.demo.dto;
import java.util.List;

public class ChatRequest {
    private String model;
    private List<ChatMessage> messages;

    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }

    public List<ChatMessage> getMessages(){
        return this.messages;
    }
    public void setMessages(List<ChatMessage> messages){
        this.messages = messages;
    }

}
