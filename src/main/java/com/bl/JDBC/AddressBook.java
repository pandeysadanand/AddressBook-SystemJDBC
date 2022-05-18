package com.bl.JDBC;

import com.bl.JDBC.AddressBookMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    PreparedStatement preparedStatement = null;
    AddressBookMain addressBookMain = new AddressBookMain();

    public void createTable(Connection con) throws Exception {
        try {
            String query = "create table contact_details(id int not null auto_increment primary key, first_name varchar(10) not null, last_name varchar(10) not null, address varchar(10), city varchar(10) not null, state varchar(10) not null, zip int(6), phone int(12) not null, email varchar(20) unique)";
            Statement statement = null;
            if (con != null) {
                statement = con.createStatement();
                int result = statement.executeUpdate(query);
                if (result != 0) {
                    System.out.println("Table created successfully");
                } else {
                    System.out.println("Table creation failed");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContact(Connection con) throws SQLException, Exception {
        try {
            String query = " insert into contact_details values(?,?,?,?,?,?,?,?)";

            preparedStatement = con.prepareStatement(query);
            System.out.println("Enter first name :");
            String fname = scanner.next();
            System.out.println("Enter last name :");
            String lname = scanner.next();
            System.out.println("Enter address :");
            String address = scanner.next();
            System.out.println("Enter city :");
            String city = scanner.next();
            System.out.println("Enter state :");
            String state = scanner.next();
            System.out.println("Enter zip code :");
            int zip = scanner.nextInt();
            System.out.println("Enter phone number :");
            int phone = scanner.nextInt();
            System.out.println("Enter email :");
            String email = scanner.next();


            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, state);
            preparedStatement.setInt(6, zip);
            preparedStatement.setInt(7, phone);
            preparedStatement.setString(8, email);

            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("Record inserted  successfully");
            } else {
                System.out.println("Record insertion failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editContact(Connection con) throws Exception {
        boolean change = true;
        do {
            System.out.println("What you want to change choose from below option:");
            System.out.println("1.Last name\n2.Address\n3.City\n4.State\n5.zip\n6.Phone\n7.Email\n8.Close edit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    editLastName(con);
                    break;
                case 2:
                    editAddress(con);
                    break;
                case 3:
                    editCity(con);
                    break;
                case 4:
                    editState(con);
                    break;
                case 5:
                    editPhone(con);
                    break;
                case 6:
                    editEmail(con);
                    break;
                case 7:
                    editZip(con);
                    break;
                default:
                    change = false;
                    System.out.println("Record edit closed !");
            }
        }while(change);
    }


    private void editZip(Connection con) throws Exception {
        String query = "update contact_details set zip = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new email :");
        int zip = scanner.nextInt();
        preparedStatement.setInt(1, zip);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }

    private void editEmail(Connection con) throws SQLException {
        String query = "update contact_details set email = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new email :");
        String email = scanner.next();
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }

    private void editPhone(Connection con) throws Exception {
        String query = "update contact_details set phone = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new phone number :");
        int phone = scanner.nextInt();
        preparedStatement.setInt(1, phone);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }


    private void editState(Connection con) throws SQLException {
        String query = "update contact_details set state = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new zip :");
        String state = scanner.next();
        preparedStatement.setString(1, state);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }


    private void editCity(Connection con) throws Exception {
        String query = "update contact_details set city = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new address :");
        String city = scanner.next();
        preparedStatement.setString(1, city);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record update failed");
        }
    }


    private void editAddress(Connection con) throws Exception {
        String query = "update contact_details set address = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new address :");
        String address = scanner.next();
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }


    private void editLastName(Connection con) throws SQLException {
        String query = "update contact_details set last_name = ? where first_name= ?";
        preparedStatement = con.prepareStatement(query);
        System.out.println("Enter first name ");
        String name = scanner.next();
        System.out.println("Enter new last name :");
        String lname = scanner.next();
        preparedStatement.setString(1, lname);
        preparedStatement.setString(2, name);
        int result = preparedStatement.executeUpdate();
        if (result != 0) {
            System.out.println("Record UPDATED successfully");
        } else {
            System.out.println("Record updated failed");
        }
    }
}
