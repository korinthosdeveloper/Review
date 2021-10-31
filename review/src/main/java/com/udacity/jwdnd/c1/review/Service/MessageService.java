package com.udacity.jwdnd.c1.review.Service;


import com.udacity.jwdnd.c1.review.Model.ChatForm;
import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class MessageService {


    private List<ChatMessage> chatMessages;


    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType().toString()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

}
