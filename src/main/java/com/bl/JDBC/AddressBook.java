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
}
