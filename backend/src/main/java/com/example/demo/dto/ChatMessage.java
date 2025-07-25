package com.example.demo.dto;

public class ChatMessage {
    private String role;
    private String content;

    public String getRole(){
        return this.role;
    }
    public void setRole(String role){
        this.role = role;
    }

    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public ChatMessage(String role, String content){
        this.role = role;
        this.content = content;
    }
}
