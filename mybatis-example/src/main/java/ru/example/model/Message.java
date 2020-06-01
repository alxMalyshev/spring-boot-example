package ru.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message {

    private Integer id;
    private String text;
    private String tag;

    public Message(){
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }
}