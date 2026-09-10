package com.foodlink.model;

import java.time.LocalDate;

public class Donation {

    private int donationId;
    private int donorId;
    private int foodId;
    private int receiverId;
    private LocalDate donationDate;
    private String status;

    public Donation(int donorId, int foodId, int receiverId,
                    LocalDate donationDate, String status) {
        this.donorId = donorId;
        this.foodId = foodId;
        this.receiverId = receiverId;
        this.donationDate = donationDate;
        this.status = status;
    }

    public int getDonorId() {
        return donorId;
    }

    public int getFoodId() {
        return foodId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public String getStatus() {
        return status;
    }
}