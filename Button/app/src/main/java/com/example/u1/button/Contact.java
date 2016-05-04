package com.example.u1.button;

/**
 * Created by U1 on 4/28/2016.
 */
public class Contact {
    String name;
    String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getContactName() {
        return name;
    }

    public String getContactPhone() {
        return phone;
    }
}
