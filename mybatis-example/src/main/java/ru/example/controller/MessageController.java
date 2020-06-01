package ru.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.model.Message;
import ru.example.mapper.MessageMapper;

import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id")Integer id) {
        return new ResponseEntity<>(messageMapper.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public String getAll(Map<String, Object> model) {
        Iterable<Message> messages = messageMapper.findAll();
        model.put("messages",messages);

        return "common";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageMapper.findAll();
        model.put("messages",messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object> model){
        Message message = new Message(text,tag);
        messageMapper.insert(message);

        Iterable<Message> messages = messageMapper.findAll();
        model.put("messages",messages);

        return "main";
    }

}

