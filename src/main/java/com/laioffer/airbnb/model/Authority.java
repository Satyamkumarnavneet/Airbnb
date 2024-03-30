package com.laioffer.airbnb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    private String username;
    private String authority;
    public Authority() {}
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Authority setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Authority setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public String getAuthority() {
        return authority;
    }
}
