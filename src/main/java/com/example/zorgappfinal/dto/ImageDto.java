package com.example.zorgappfinal.dto;


public class ImageDto {

    Long id;
    public String content;
    private MessageDto message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public MessageDto getMessage(){
        return message;
    }
    public void addToMessage (MessageDto message){
        this.message = message;
    }
}
