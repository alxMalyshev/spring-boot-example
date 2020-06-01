package ru.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.model.Message;
import ru.example.mapper.MessageRepository;

import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/employee")
    public String employee(@RequestParam(name = "name", required = false, defaultValue = "Vasya") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "employee";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages",messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object> model){
        Message message = new Message(text,tag);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages",messages);

        return "main";
    }



}

