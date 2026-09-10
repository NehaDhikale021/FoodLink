package com.foodlink.dao;
import java.time.LocalDate;

import com.foodlink.DBConnection;
import com.foodlink.model.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodDAO {

    public void addFood(FoodItem food) {
        if (food.getQuantity() <= 0) {
            System.out.println("Quantity must be greater than 0!");
            return;
        }

        if (food.getExpiryDate().isBefore(LocalDate.now())) {
            System.out.println("Expiry date cannot be in the past!");
            return;
        }

        String sql = "INSERT INTO food_items " +
                "(food_name, quantity, unit, food_type, expiry_date) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, food.getFoodName());
            statement.setInt(2, food.getQuantity());
            statement.setString(3, food.getUnit());
            statement.setString(4, food.getFoodType());
            statement.setDate(5, java.sql.Date.valueOf(food.getExpiryDate()));

            statement.executeUpdate();

            System.out.println("Food added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding food!");
            e.printStackTrace();
        }
    }

    public void viewAllFood() {

        String sql = "SELECT * FROM food_items";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            System.out.println("\n===== ALL FOOD ITEMS =====");

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("food_id"));
                System.out.println("Food: " + resultSet.getString("food_name"));
                System.out.println("Quantity: " + resultSet.getInt("quantity"));
                System.out.println("Unit: " + resultSet.getString("unit"));
                System.out.println("Type: " + resultSet.getString("food_type"));
                System.out.println("Expiry Date: " + resultSet.getDate("expiry_date"));
                System.out.println("--------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching food!");
            e.printStackTrace();
        }
    }

    public void updateFood(int foodId, String foodName, int quantity,
                           String unit, String foodType,
                           java.time.LocalDate expiryDate) {

        String sql = "UPDATE food_items SET food_name = ?, quantity = ?, " +
                "unit = ?, food_type = ?, expiry_date = ? WHERE food_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, foodName);
            statement.setInt(2, quantity);
            statement.setString(3, unit);
            statement.setString(4, foodType);
            statement.setDate(5, java.sql.Date.valueOf(expiryDate));
            statement.setInt(6, foodId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Food updated successfully!");
            } else {
                System.out.println("Food not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating food!");
            e.printStackTrace();
        }
    }

    public void deleteFood(int foodId) {

        String sql = "DELETE FROM food_items WHERE food_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, foodId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Food deleted successfully!");
            } else {
                System.out.println("Food not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting food!");
            e.printStackTrace();
        }
    }
}