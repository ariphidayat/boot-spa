package com.arip.repository.eventhandler;

import com.arip.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 9/2/2017.
 */
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @HandleBeforeCreate
    public void handleBeforeCreate(User user) {
        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
    }

}
