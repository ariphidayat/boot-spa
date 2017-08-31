package com.arip.repository;

import com.arip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arip Hidayat on 8/31/2017.
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
