package com.foodlink.dao;

import com.foodlink.DBConnection;
import com.foodlink.model.Donor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonorDAO {

    public void addDonor(Donor donor) {

        String sql = "INSERT INTO donors (name, phone, email, address) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, donor.getName());
            statement.setString(2, donor.getPhone());
            statement.setString(3, donor.getEmail());
            statement.setString(4, donor.getAddress());

            statement.executeUpdate();

            System.out.println("Donor added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding donor!");
            e.printStackTrace();
        }
    }

    public void viewAllDonors() {

        String sql = "SELECT * FROM donors";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            System.out.println("\n===== ALL DONORS =====");

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("donor_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching donors!");
            e.printStackTrace();
        }
    }

    public void updateDonor(int donorId, String name, String phone, String email, String address) {

        String sql = "UPDATE donors SET name = ?, phone = ?, email = ?, address = ? WHERE donor_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, address);
            statement.setInt(5, donorId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Donor updated successfully!");
            } else {
                System.out.println("Donor not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating donor!");
            e.printStackTrace();
        }
    }

    public void deleteDonor(int donorId) {

        String sql = "DELETE FROM donors WHERE donor_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, donorId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Donor deleted successfully!");
            } else {
                System.out.println("Donor not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting donor!");
            e.printStackTrace();
        }
    }
}