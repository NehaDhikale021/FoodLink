package com.foodlink.dao;

import com.foodlink.DBConnection;
import com.foodlink.model.Receiver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceiverDAO {

    public void addReceiver(Receiver receiver) {

        String sql = "INSERT INTO receivers (name, phone, email, address) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, receiver.getName());
            statement.setString(2, receiver.getPhone());
            statement.setString(3, receiver.getEmail());
            statement.setString(4, receiver.getAddress());

            statement.executeUpdate();

            System.out.println("Receiver added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding receiver!");
            e.printStackTrace();
        }
    }

    public void viewAllReceivers() {

        String sql = "SELECT * FROM receivers";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            System.out.println("\n===== ALL RECEIVERS =====");

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("receiver_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("-------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching receivers!");
            e.printStackTrace();
        }
    }

    public void updateReceiver(int receiverId, String name, String phone,
                               String email, String address) {

        String sql = "UPDATE receivers SET name = ?, phone = ?, email = ?, address = ? " +
                "WHERE receiver_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, address);
            statement.setInt(5, receiverId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Receiver updated successfully!");
            } else {
                System.out.println("Receiver not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating receiver!");
            e.printStackTrace();
        }
    }

    public void deleteReceiver(int receiverId) {

        String sql = "DELETE FROM receivers WHERE receiver_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, receiverId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Receiver deleted successfully!");
            } else {
                System.out.println("Receiver not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting receiver!");
            e.printStackTrace();
        }
    }
}