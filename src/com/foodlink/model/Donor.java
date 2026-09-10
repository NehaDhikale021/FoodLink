package com.foodlink.model;

public class Donor {

    private int donorId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Donor(int donorId, String name, String phone, String email, String address) {
        this.donorId = donorId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Donor(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getDonorId() {
        return donorId;
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
