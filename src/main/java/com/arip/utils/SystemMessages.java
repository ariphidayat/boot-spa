package com.arip.utils;

import com.arip.model.InstantMessage;

/**
 * Created by Arip Hidayat on 9/30/2017.
 */
public class SystemMessages {

    public static final InstantMessage join(String username) {
        return new InstantMessageBuilder().newMessage().systemMessage().withContent(username + " joined.");
    }

    public static final InstantMessage leave(String username) {
        return new InstantMessageBuilder().newMessage().systemMessage().withContent(username + " left.");
    }
}
