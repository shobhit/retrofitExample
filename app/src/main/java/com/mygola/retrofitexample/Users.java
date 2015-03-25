package com.mygola.retrofitexample;

/**
 * Created by shobhit on 3/25/15.
 */
public class Users {
    private String name;
    private String username;

    public Users() {
    }

    public Users(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
