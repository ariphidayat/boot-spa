package com.arip.service;

import com.arip.model.InstantMessage;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
public interface ChatService {

    void sendPrivateMessage(InstantMessage instantMessage);

    void sendPublicMessage(InstantMessage instantMessage);
}
