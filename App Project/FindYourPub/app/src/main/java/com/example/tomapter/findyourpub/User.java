package com.example.tomapter.findyourpub;

import android.util.Log;

/**
 * Created by tomapter on 22/11/2016.
 */

public class User {
    private String userName;
    private String name;
    private String password;
    private String age;
    private int id;

    public User(int id, String userName, String name, String password, String age){
        this.userName = userName;
        this.name=name;
        this.password=password;
        this.id = id;
        this.age = age;
    }

    public User(String userName, String name, String password, String age){
        this.userName = userName;
        this.name=name;
        this.password=password;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
