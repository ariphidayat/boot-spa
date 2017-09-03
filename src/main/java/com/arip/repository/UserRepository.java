package com.arip.repository;

import com.arip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Arip Hidayat on 8/31/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(@Param("email") String email);
}
