package com.example.api;

import java.util.UUID;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
public final class User {

    private UUID id = UUID.randomUUID();
    private String userName;
    private String realName;

    public UUID getId() {
        return id;
    }

    public User setId(final UUID id) {
        this.id = id;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public User setRealName(final String realName) {
        this.realName = realName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

}
