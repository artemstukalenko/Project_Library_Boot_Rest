package com.artemstukalenko.library.project_library_boot.entity;

import com.artemstukalenko.library.project_library_boot.view.FirstView;
import com.artemstukalenko.library.project_library_boot.view.TextConstants;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private int enabled;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled == 0 ? FirstView.userBlocked : FirstView.userNotBlocked;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
