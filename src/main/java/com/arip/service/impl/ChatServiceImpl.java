package com.arip.service.impl;

import com.arip.model.InstantMessage;
import com.arip.service.ChatService;
import com.arip.utils.Destinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendPrivateMessage(InstantMessage instantMessage) {
        simpMessagingTemplate.convertAndSendToUser(
                instantMessage.getTo(),
                Destinations.Chat.privateMessages(),
                instantMessage
        );
    }

    @Override
    public void sendPublicMessage(InstantMessage instantMessage) {
        simpMessagingTemplate.convertAndSend(
                Destinations.Chat.publicMessages(),
                instantMessage
        );
    }
}
