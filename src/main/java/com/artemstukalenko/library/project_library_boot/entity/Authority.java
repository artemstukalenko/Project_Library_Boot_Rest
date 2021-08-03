package com.artemstukalenko.library.project_library_boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    public Authority() {}

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }
}
