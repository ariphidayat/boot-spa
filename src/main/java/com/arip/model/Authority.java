package com.arip.model;

import javax.persistence.*;

/**
 * Created by Arip Hidayat on 8/31/2017.
 */
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user;

    @Column
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
