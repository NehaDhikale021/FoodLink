package com.foodlink;

import com.foodlink.dao.DonorDAO;
import com.foodlink.model.Donor;
import com.foodlink.dao.ReceiverDAO;
import com.foodlink.model.Receiver;
import com.foodlink.dao.FoodDAO;
import com.foodlink.model.FoodItem;
import com.foodlink.dao.DonationDAO;
import com.foodlink.model.Donation;

import java.time.LocalDate;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DonorDAO donorDAO = new DonorDAO();
        ReceiverDAO receiverDAO = new ReceiverDAO();
        FoodDAO foodDAO = new FoodDAO();
        DonationDAO donationDAO = new DonationDAO();

        while (true) {

            System.out.println("\n===== FOODLINK =====");
            System.out.println("1. Add Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. Update Donor");
            System.out.println("4. Delete Donor");
            System.out.println("5. Add Receiver");
            System.out.println("6. View All Receivers");
            System.out.println("7. Update Receiver");
            System.out.println("8. Delete Receiver");
            System.out.println("9. Add Food");
            System.out.println("10. View All food");
            System.out.println("11. Update Food");
            System.out.println("12. Delete Food");
            System.out.println("13. Add Donation");
            System.out.println("14. View All Donations");
            System.out.println("15. update Donation Status");
            System.out.println("16. Delete Donations");
            System.out.println("17. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter donor name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Donor donor = new Donor(name, phone, email, address);
                    donorDAO.addDonor(donor);
                    break;

                case 2:
                    donorDAO.viewAllDonors();
                    break;

                case 3:
                    System.out.print("Enter donor ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();

                    donorDAO.updateDonor(
                            updateId, newName, newPhone,
                            newEmail, newAddress
                    );
                    break;

                case 4:
                    System.out.print("Enter donor ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    donorDAO.deleteDonor(deleteId);
                    break;

                case 5:
                    System.out.print("Enter receiver name: ");
                    String receiverName = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String receiverPhone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String receiverEmail = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String receiverAddress = scanner.nextLine();

                    Receiver receiver = new Receiver(
                            receiverName,
                            receiverPhone,
                            receiverEmail,
                            receiverAddress
                    );

                    receiverDAO.addReceiver(receiver);
                    break;

                case 6:
                    receiverDAO.viewAllReceivers();
                    break;

                case 7:
                    System.out.print("Enter receiver ID to update: ");
                    int updateReceiverId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newReceiverName = scanner.nextLine();

                    System.out.print("Enter new phone: ");
                    String newReceiverPhone = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newReceiverEmail = scanner.nextLine();

                    System.out.print("Enter new address: ");
                    String newReceiverAddress = scanner.nextLine();

                    receiverDAO.updateReceiver(
                            updateReceiverId,
                            newReceiverName,
                            newReceiverPhone,
                            newReceiverEmail,
                            newReceiverAddress
                    );
                    break;

                case 8:
                    System.out.print("Enter receiver ID to delete: ");
                    int deleteReceiverId = scanner.nextInt();
                    scanner.nextLine();

                    receiverDAO.deleteReceiver(deleteReceiverId);
                    break;

                case 9:
                    System.out.print("Enter food name: ");
                    String foodName = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter unit (plates/kg/litre): ");
                    String unit = scanner.nextLine();

                    System.out.print("Enter food type: ");
                    String foodType = scanner.nextLine();

                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

                    FoodItem food = new FoodItem(
                            foodName,
                            quantity,
                            unit,
                            foodType,
                            expiryDate
                    );

                    foodDAO.addFood(food);
                    break;

                case 10:
                    foodDAO.viewAllFood();
                    break;

                case 11:
                    System.out.print("Enter food ID to update: ");
                    int updateFoodId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new food name: ");
                    String newFoodName = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new unit: ");
                    String newUnit = scanner.nextLine();

                    System.out.print("Enter new food type: ");
                    String newFoodType = scanner.nextLine();

                    System.out.print("Enter new expiry date (YYYY-MM-DD): ");
                    LocalDate newExpiryDate = LocalDate.parse(scanner.nextLine());

                    foodDAO.updateFood(
                            updateFoodId,
                            newFoodName,
                            newQuantity,
                            newUnit,
                            newFoodType,
                            newExpiryDate
                    );
                    break;

                case 12:
                    System.out.print("Enter food ID to delete: ");
                    int deleteFoodId = scanner.nextInt();
                    scanner.nextLine();

                    foodDAO.deleteFood(deleteFoodId);
                    break;

                case 13:
                    System.out.print("Enter donor ID: ");
                    int donorId = scanner.nextInt();

                    System.out.print("Enter food ID: ");
                    int foodId = scanner.nextInt();

                    System.out.print("Enter receiver ID: ");
                    int receiverId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter donation date (YYYY-MM-DD): ");
                    LocalDate donationDate = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();

                    Donation donation = new Donation(
                            donorId,
                            foodId,
                            receiverId,
                            donationDate,
                            status
                    );

                    donationDAO.addDonation(donation);
                    break;

                case 14:
                    donationDAO.viewAllDonations();
                    break;

                case 15:
                    System.out.print("Enter donation ID: ");
                    int donationId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();

                    donationDAO.updateDonationStatus(donationId, newStatus);
                    break;

                case 16:
                    System.out.print("Enter donation ID to delete: ");
                    int deleteDonationId = scanner.nextInt();
                    scanner.nextLine();

                    donationDAO.deleteDonation(deleteDonationId);
                    break;

                case 17:
                    System.out.println("Thank you for using FoodLink!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}