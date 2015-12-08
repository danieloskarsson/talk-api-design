package com.example.api;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
public final class User {

    private String name;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public User setName(final String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(final String username) {
        this.username = username;
        return this;
    }

    String getPassword() {
        return password;
    }

    User setPassword(final String password) {
        this.password = password;
        return this;
    }

}
