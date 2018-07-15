package com.example.lxx.atm;

import org.litepal.crud.DataSupport;

/**
 * Created by lxx on 2017/8/14.
 */

public class User extends DataSupport {
    private int id;
    private String name;
    private String password;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
