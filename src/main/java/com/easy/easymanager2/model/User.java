package com.easy.easymanager2.model;

import jakarta.persistence.*;

@Table(name = "dim_users")
@Entity(name = "User")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;
    private String type_user; // Exemplo: "admin", "user"

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return login;
    }

    public void setUsername(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return type_user;
    }

    public void setRole(String role) {
        this.type_user = role;
    }
}
