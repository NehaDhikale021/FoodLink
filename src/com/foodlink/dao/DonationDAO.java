package com.foodlink.dao;

import com.foodlink.DBConnection;
import com.foodlink.model.Donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonationDAO {

    public void addDonation(Donation donation) {

        String sql = "INSERT INTO donations " +
                "(donor_id, food_id, receiver_id, donation_date, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, donation.getDonorId());
            statement.setInt(2, donation.getFoodId());
            statement.setInt(3, donation.getReceiverId());
            statement.setDate(4, java.sql.Date.valueOf(donation.getDonationDate()));
            statement.setString(5, donation.getStatus());

            statement.executeUpdate();

            System.out.println("Donation added successfully!");

        } catch (SQLException e) {
            System.out.println("Invalid donor, food, or receiver ID!");
        }
    }

    public void viewAllDonations() {

        String sql = "SELECT * FROM donations";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            System.out.println("\n===== ALL DONATIONS =====");

            while (resultSet.next()) {

                System.out.println("Donation ID: "
                        + resultSet.getInt("donation_id"));

                System.out.println("Donor ID: "
                        + resultSet.getInt("donor_id"));

                System.out.println("Food ID: "
                        + resultSet.getInt("food_id"));

                System.out.println("Receiver ID: "
                        + resultSet.getInt("receiver_id"));

                System.out.println("Donation Date: "
                        + resultSet.getDate("donation_date"));

                System.out.println("Status: "
                        + resultSet.getString("status"));

                System.out.println("--------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching donations!");
            e.printStackTrace();
        }
    }

    public void updateDonationStatus(int donationId, String status) {

        String sql = "UPDATE donations SET status = ? " +
                "WHERE donation_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, donationId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Donation status updated successfully!");
            } else {
                System.out.println("Donation not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating donation!");
            e.printStackTrace();
        }
    }

    public void deleteDonation(int donationId) {

        String sql = "DELETE FROM donations WHERE donation_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, donationId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Donation deleted successfully!");
            } else {
                System.out.println("Donation not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting donation!");
            e.printStackTrace();
        }
    }
}