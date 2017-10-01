package com.arip.utils;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
public class Destinations {

    public static class Chat {

        public static String privateMessages() {
            return "/queue/private.messages";
        }

        public static String publicMessages() {
            return "/topic/public.messages";
        }

        public static String connectedUsers() {
            return "/topic/connected.users";
        }
    }
}
