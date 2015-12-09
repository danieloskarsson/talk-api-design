package com.example.api;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
public final class User {

    private String userName;
    private String realName;

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
