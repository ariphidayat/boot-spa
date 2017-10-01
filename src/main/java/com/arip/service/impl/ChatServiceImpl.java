package com.arip.service.impl;

import com.arip.model.InstantMessage;
import com.arip.service.ChatService;
import com.arip.utils.Destinations;
import com.arip.utils.SystemMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private Set<String> connectedUsers = new HashSet<>();

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

    @Override
    public void join(Principal user) {
        connectedUsers.add(user.getName());
        updateConnectedUsers();
        sendPublicMessage(SystemMessages.join(user.getName()));
    }

    @Override
    public void leave(Principal user) {
        connectedUsers.remove(user.getName());
        updateConnectedUsers();
        sendPublicMessage(SystemMessages.leave(user.getName()));
    }

    private void updateConnectedUsers() {
        if (!connectedUsers.contains("public")) {
            connectedUsers.add("public");
        }

        simpMessagingTemplate.convertAndSend(
                Destinations.Chat.connectedUsers(),
                connectedUsers
        );
    }
}
