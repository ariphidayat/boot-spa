package com.arip.config;

import com.arip.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by Arip Hidayat on 9/30/2017.
 */
@Component
public class WebSocketEvents {

    @Autowired
    private ChatService chatService;

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        chatService.join(event.getUser());
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        chatService.leave(event.getUser());
    }
}
