package com.arip.utils;

import com.arip.model.InstantMessage;

/**
 * Created by Arip Hidayat on 9/30/2017.
 */
public class InstantMessageBuilder {

    private InstantMessage instantMessage;

    public InstantMessageBuilder() {}

    public InstantMessageType newMessage() {
        instantMessage = new InstantMessage();
        return new InstantMessageType();
    }

    public class InstantMessageType {
        public InstantMessageContent systemMessage() {
            instantMessage.setFrom("ADMIN");
            return new InstantMessageContent();
        }
    }

    public class InstantMessageContent {
        public InstantMessage withContent(String content) {
            instantMessage.setContent(content);
            return instantMessage;
        }
    }
}
