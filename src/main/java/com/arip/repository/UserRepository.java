package com.arip.repository;

import com.arip.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Arip Hidayat on 8/31/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(@Param("email") String email);

    @PreAuthorize("hasAuthority('USER_SEARCH')")
    @Override
    Page<User> findAll(Pageable pageable);
}
