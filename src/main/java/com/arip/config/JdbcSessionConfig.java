package com.arip.config;

import org.springframework.context.annotation.Profile;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

/**
 * Created by Arip Hidayat on 9/8/2017.
 */
@Profile("session-jdbc")
@EnableJdbcHttpSession
public class JdbcSessionConfig {}
