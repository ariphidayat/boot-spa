package com.arip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

/**
 * Created by Arip Hidayat on 9/8/2017.
 */
@EnableJdbcHttpSession
public class HttpSessionConfig {

    @Bean
    public HeaderHttpSessionStrategy strategy() {
        return new HeaderHttpSessionStrategy();
    }
}
