package com.arip.service;

import com.arip.model.InstantMessage;

import java.security.Principal;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
public interface ChatService {

    void sendPrivateMessage(InstantMessage instantMessage);

    void sendPublicMessage(InstantMessage instantMessage);

    void join(Principal user);

    void leave(Principal user);
}
