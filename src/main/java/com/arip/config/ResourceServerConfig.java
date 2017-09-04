 package com.arip.config;

 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpMethod;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
 import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by Arip Hidayat on 8/30/2017.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST,"/api/users").permitAll()
            .antMatchers( "/api/**").hasAuthority("DEVELOPER")
            .and()
            .formLogin();
    }
}
