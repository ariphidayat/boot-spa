package com.arip.controller;

import com.arip.model.InstantMessage;
import com.arip.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/send.message")
    public void sendMessage(@Payload InstantMessage instantMessage, Principal principal) {
        instantMessage.setFrom(principal.getName());

        if (instantMessage.isPublic()) {
            chatService.sendPublicMessage(instantMessage);
        } else {
            chatService.sendPrivateMessage(instantMessage);
        }
    }
}
