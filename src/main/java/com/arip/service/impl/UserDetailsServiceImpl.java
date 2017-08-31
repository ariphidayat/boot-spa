package com.arip.service.impl;

import com.arip.model.Authority;
import com.arip.model.User;
import com.arip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Arip Hidayat on 8/31/2017.
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        List<GrantedAuthority> authorities =  buildUserAuthority(user.getAuthorities());

        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Authority> authorities) {
        Set<GrantedAuthority> setAuthorities = new HashSet<>();
        for (Authority authority : authorities) {
            setAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new ArrayList<>(setAuthorities);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }
}
