package com.foodlink.model;

public class Receiver {

    private int receiverId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Receiver(int receiverId, String name, String phone, String email, String address) {
        this.receiverId = receiverId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Receiver(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}