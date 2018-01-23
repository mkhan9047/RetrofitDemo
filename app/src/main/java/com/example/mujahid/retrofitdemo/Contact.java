package com.example.mujahid.retrofitdemo;

/**
 * Created by Mujahid on 1/23/2018.
 */

public class Contact {
    private String name, father_name, phone, email;

    public Contact(String name, String father_name, String phone, String email) {
        this.name = name;
        this.father_name = father_name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
